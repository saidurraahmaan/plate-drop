import fetchClient from '@/libs/fetchClient';
import { IUser } from '@/types/User';
import { TLoginFieldType } from './login/types';

const BASE_URL = '/auth';
const getEndpoint = (endpoint: string) => `${BASE_URL}${endpoint}`;

const AUTH_API = {
  login: getEndpoint('/signin'),
  registration: getEndpoint('/signup'),
};

export const loginUser = async (data: TLoginFieldType) => {
  const result = await fetchClient.post<IUser, TLoginFieldType>(
    AUTH_API.login,
    data
  );
  //JWT-TOKEN

  return result;
};
