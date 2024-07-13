import fetchClient from '@/libs/fetchClient';
import { IRestaurantFieldType } from './add-new/type';

const BASE_URL = '/restaurant';

const getEndpoint = (endpoint: string) => `${BASE_URL}${endpoint}`;

export const RESTAURANT_API = {
  add: getEndpoint('/add'),
  delete: getEndpoint('/delete'),
  userRestaurants: getEndpoint('/all'),
};

export const addRestaurant = (data: IRestaurantFieldType) => {
  return fetchClient.post(RESTAURANT_API.add, data);
};
