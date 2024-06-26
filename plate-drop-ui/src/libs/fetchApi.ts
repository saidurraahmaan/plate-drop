const API_BASE_URL = process.env.API_BASE_URL;

type RequestMethod = 'GET' | 'POST' | 'DELETE';

interface FetchOptions {
  method?: RequestMethod;
  body?: any;
  cache?: RequestCache;
  revalidate?: number;
}

const fetchApi = async <T>(
  endpoint: string,
  { method = 'GET', body, cache = 'default', revalidate }: FetchOptions = {}
): Promise<T | null> => {
  const headers = new Headers({
    'Content-Type': 'application/json',
  });

  const options: RequestInit = {
    method,
    headers,
    cache,
    body: body ? JSON.stringify(body) : undefined,
  };

  if (revalidate !== undefined) {
    headers.append('x-vercel-revalidate', revalidate.toString());
  }

  const res = await fetch(`${API_BASE_URL}${endpoint}`, options);
  const contentType = res.headers.get('Content-Type') || '';

  // Log the raw response for debugging

  if (!res.ok) {
    const data = await res.json();
    throw new Error(data.message);
  }

  const contentLength = res.headers.get('Content-Length');
  if (contentLength === '0' || !contentType.includes('application/json')) {
    return null;
  }
  return res.json();
};

const fetchInstance = {
  get: async <T>(
    endpoint: string,
    cache?: RequestCache,
    revalidate?: number
  ): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'GET', cache, revalidate });
  },
  post: async <T, U>(endpoint: string, body: U): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'POST', body });
  },
  del: async <T, U>(endpoint: string, body: U): Promise<T | null> => {
    return fetchApi<T>(endpoint, { method: 'DELETE', body });
  },
};

export default fetchInstance;
