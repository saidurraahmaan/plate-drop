'use client';
import React from 'react';
import { message } from 'antd';
import AddRestaurantForm from './AddRestaurantForm';
import { IRestaurant } from './type';

const AddNewRestaurant: React.FC = () => {
  const handleAddRestaurant = (values: IRestaurant) => {
    console.log('Received values of form: ', values);
    message.success('Restaurant added successfully!');
  };

  return (
    <div className="d-flex justify-content-center">
      <AddRestaurantForm
        onAddRestaurant={handleAddRestaurant}
        className="wd-100"
      />
    </div>
  );
};

export default AddNewRestaurant;
