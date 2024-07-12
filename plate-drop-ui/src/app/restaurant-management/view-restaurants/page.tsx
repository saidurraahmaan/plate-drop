'use client';
import React, { useEffect, useState } from 'react';
import { fetchUserRestaurants } from '../api';

const ViewRestaurants = () => {
  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => {
    const fetch = async () => {
      try {
        const data = await fetchUserRestaurants();
        console.log(data);
      } catch (error) {
        console.error(error);
      }
    };
    fetch();
  }, []);

  console.log(restaurants);

  return <div>ViewRestaurants</div>;
};

export default ViewRestaurants;
