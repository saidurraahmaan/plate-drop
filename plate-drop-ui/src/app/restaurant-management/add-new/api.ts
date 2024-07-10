import fetchInstance from '@/libs/fetchApi';
import { IRestaurantFieldType } from './type';

const BASE_URL = '/restaurant';

const getEndpoint = (endpoint: string) => `${BASE_URL}${endpoint}`;

const RESTAURANT_API = {
  add: getEndpoint('/add'),
  delete: getEndpoint('/delete'),
};

export const addRestaurant = (data: IRestaurantFieldType) => {
  return fetchInstance.post(RESTAURANT_API.add, data);
};
