'use client';
import React from 'react';
import { Table } from 'antd';
import type { TableColumnsType } from 'antd';
import { IRestaurant } from '../add-new/type';

interface DataType {
  key: React.Key;
  name: string;
  cuisine: string;
  description: string;
  imageUrl: string;
}
const columns: TableColumnsType<DataType> = [
  { title: 'Name', dataIndex: 'name', key: 'name' },
  { title: 'Cuisine', dataIndex: 'cuisine', key: 'cuisine' },
  { title: 'Description', dataIndex: 'description', key: 'description' },
  {
    title: 'Action',
    dataIndex: '',
    key: 'x',
    render: () => <a>Delete</a>,
  },
];

interface RestaurantListProps {
  restaurants: IRestaurant[];
}

const RestaurantList: React.FC<RestaurantListProps> = ({ restaurants }) => {
  const data: DataType[] = restaurants.map((restaurant) => ({
    key: restaurant.id, // Assuming `id` exists in IRestaurant
    name: restaurant.name,
    cuisine: restaurant.cuisine,
    description: restaurant.description,
    imageUrl: restaurant.imageUrl,
  }));

  return (
    <div>
      <Table
        columns={columns}
        expandable={{
          expandedRowRender: (record) => (
            <p style={{ margin: 0 }}>{record.description}</p>
          ),
          rowExpandable: (record) => record.name !== 'Not Expandable',
        }}
        dataSource={data}
        pagination={false}
      />
    </div>
  );
};
export default RestaurantList;
