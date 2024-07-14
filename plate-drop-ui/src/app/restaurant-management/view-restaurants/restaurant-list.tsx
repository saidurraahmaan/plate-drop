'use client';
import React from 'react';
import { Table } from 'antd';
import type { TableColumnsType } from 'antd';
import { IRestaurant } from '../add-new/type';
import { useRouter } from 'next/navigation';

interface DataType {
  key: React.Key;
  name: string;
  cuisine: string;
  description: string;
  imageUrl: string;
}

interface RestaurantListProps {
  restaurants: IRestaurant[];
}

const RestaurantList: React.FC<RestaurantListProps> = ({ restaurants }) => {
  const router = useRouter();

  const handleUpdate = (key: React.Key) => {
    router.push(`/update/${key}`);
  };

  const handleDelete = (key: React.Key) => {
    console.log('Delete', key);
  };
  const data: DataType[] = restaurants.map((restaurant) => ({
    key: restaurant.id,
    name: restaurant.name,
    cuisine: restaurant.cuisine,
    description: restaurant.description,
    imageUrl: restaurant.imageUrl,
  }));

  const columns: TableColumnsType<DataType> = [
    { title: 'Name', dataIndex: 'name', key: 'name' },
    { title: 'Cuisine', dataIndex: 'cuisine', key: 'cuisine' },
    // { title: 'Description', dataIndex: 'description', key: 'description' },

    {
      title: 'Action',
      dataIndex: '',
      key: 'x',
      render: (_, record) => (
        <span>
          <a
            style={{ marginRight: 16 }}
            onClick={() => handleUpdate(record.key)}
          >
            Update
          </a>
          <a onClick={() => handleDelete(record.key)}>Delete</a>
        </span>
      ),
    },
  ];

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
