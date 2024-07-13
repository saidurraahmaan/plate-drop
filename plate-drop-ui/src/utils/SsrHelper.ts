import { cookies } from 'next/headers';

export const getCookiesHeader = () => {
  return {
    Cookie: cookies().toString(),
  };
};
