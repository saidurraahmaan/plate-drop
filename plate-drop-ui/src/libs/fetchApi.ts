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
): Promise<any> => {
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
  const rawResponse = await res.text();

  if (!res.ok) {
    throw new Error(`An error occurred: ${res.statusText}`);
  }

  if (contentType.includes('text/plain;charset=UTF-8')) {
    try {
      const data = JSON.parse(rawResponse);
      console.log('data');
      return data as T;
    } catch (error) {
      if (error instanceof Error) {
        throw new Error(`Failed to parse JSON: ${error.message}`);
      } else {
        throw new Error('Failed to parse JSON: Unknown error');
      }
    }
  } else {
    throw new Error('Received non-JSON response');
  }
};

const fetchInstance = {
  get: async <T>(
    endpoint: string,
    cache?: RequestCache,
    revalidate?: number
  ): Promise<T> => {
    return fetchApi<T>(endpoint, { method: 'GET', cache, revalidate });
  },
  post: async <T, U>(endpoint: string, body: U): Promise<T> => {
    return fetchApi<T>(endpoint, { method: 'POST', body });
  },
  del: async <T, U>(endpoint: string, body: U): Promise<T> => {
    return fetchApi<T>(endpoint, { method: 'DELETE', body });
  },
};

export default fetchInstance;
