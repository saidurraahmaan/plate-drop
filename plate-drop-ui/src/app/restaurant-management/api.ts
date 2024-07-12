import fetchInstance from '@/libs/fetchApi';
import { IRestaurant, IRestaurantFieldType } from './add-new/type';

const BASE_URL = '/restaurant';

const getEndpoint = (endpoint: string) => `${BASE_URL}${endpoint}`;

const RESTAURANT_API = {
  add: getEndpoint('/add'),
  delete: getEndpoint('/delete'),
  userRestaurants: getEndpoint('/all'),
};

export const addRestaurant = (data: IRestaurantFieldType) => {
  return fetchInstance.post(RESTAURANT_API.add, data);
};

export const fetchUserRestaurants = () => {
  return fetchInstance.get<IRestaurant[]>(RESTAURANT_API.userRestaurants);
};
