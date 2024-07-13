import { AppError } from '@/types/Error';
const API_BASE_URL = process.env.API_BASE_URL;

type RequestMethod = 'GET' | 'POST' | 'DELETE';

interface FetchOptions {
  method?: RequestMethod;
  body?: any;
  cache?: RequestCache;
  revalidate?: number;
  headers?: HeadersInit; // Add headers to the FetchOptions
}

const fetchApi = async <T>(
  endpoint: string,
  {
    method = 'GET',
    body,
    cache = 'default',
    revalidate,
    headers: customHeaders,
  }: FetchOptions = {}
): Promise<T | null> => {
  const headers = new Headers({
    'Content-Type': 'application/json',
    ...customHeaders, // Merge custom headers
  });

  const options: RequestInit & { next?: { revalidate?: number } } = {
    method,
    headers,
    cache,
    body: body ? JSON.stringify(body) : undefined,
    credentials: 'include',
  };

  if (!revalidate) {
    options.next = { revalidate };
  }

  const res = await fetch(`${API_BASE_URL}${endpoint}`, options);
  const contentType = res.headers.get('Content-Type') || '';

  if (!res.ok) {
    const data = await res.json();
    throw new AppError(data.message, data.code);
  }

  const contentLength = res.headers.get('Content-Length');
  if (contentLength === '0' || !contentType.includes('application/json')) {
    return null;
  }

  return res.json();
};

const fetchClient = {
  get: async <T>(
    endpoint: string,
    cache?: RequestCache,
    revalidate?: number,
    headers?: HeadersInit // Add headers parameter to the get method
  ): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'GET', cache, revalidate, headers });
  },
  post: async <T, U>(endpoint: string, body: U): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'POST', body });
  },
  delete: async <T, U>(endpoint: string, body: U): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'DELETE', body });
  },
};

export default fetchClient;
