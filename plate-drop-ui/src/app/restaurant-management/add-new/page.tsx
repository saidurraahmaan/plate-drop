'use client';
import React from 'react';
import { message } from 'antd';
import AddRestaurantForm from './AddRestaurantForm';
import { IRestaurantFieldType } from './type';
import { addRestaurant } from './api';

const AddNewRestaurant: React.FC = () => {
  const handleAddRestaurant = async (values: IRestaurantFieldType) => {
    try {
      await addRestaurant(values);
      message.success('Restaurant added successfully!');
    } catch (error) {
      message.error('Restaurant add failed!');
    }
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
