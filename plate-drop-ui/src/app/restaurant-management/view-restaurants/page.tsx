import React from 'react';
import { RESTAURANT_API } from '@/app/restaurant-management/api';
import fetchClient from '@/libs/fetchClient';
import { getCookiesHeader } from '@/utils/SsrHelper';
import { IRestaurant } from '../add-new/type';
import RestaurantList from './restaurant-list';

const ViewRestaurants = async () => {
  const restaurants = await fetchClient.get<IRestaurant[]>(
    RESTAURANT_API.userRestaurants,
    undefined,
    2,
    getCookiesHeader()
  );

  if (!restaurants) {
    return <div>No restaurants found.</div>;
  }

  return (
    <div>
      <RestaurantList restaurants={restaurants} />
    </div>
  );
};

export default ViewRestaurants;
