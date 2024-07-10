'use client';
import React from 'react';
import { Form } from 'antd';
import { IAddRestaurantFormProps, IRestaurantFieldType } from './type';
import { AppTextArea, PrimaryButton, PrimaryInput } from '@/components';

const AddRestaurantForm: React.FC<IAddRestaurantFormProps> = ({
  onAddRestaurant,
  className,
}) => {
  const [form] = Form.useForm();

  const onFinish = (values: IRestaurantFieldType) => {
    onAddRestaurant(values);
    form.resetFields();
  };

  return (
    <Form
      form={form}
      layout="vertical"
      labelCol={{ span: 8 }}
      wrapperCol={{ span: 16 }}
      style={{ maxWidth: 600 }}
      onFinish={onFinish}
      initialValues={{
        name: '',
        cuisine: '',
        description: '',
        imageUrl: '',
      }}
      className={className}
    >
      <Form.Item
        label="Name"
        name="name"
        rules={[
          {
            required: true,
            message: 'Please input the name of the restaurant!',
          },
        ]}
      >
        <PrimaryInput />
      </Form.Item>

      <Form.Item
        label="Cuisine"
        name="cuisine"
        // rules={[{ required: true, message: 'Please input the cuisine type!' }]}
      >
        <PrimaryInput />
      </Form.Item>

      <Form.Item
        label="Description"
        name="description"
        // rules={[{ required: true, message: 'Please input the description!' }]}
      >
        <AppTextArea />
      </Form.Item>

      <Form.Item
        label="Image URL"
        name="imageUrl"
        // rules={[{ required: true, message: 'Please input the image URL!' }]}
      >
        <PrimaryInput />
      </Form.Item>

      <Form.Item>
        <PrimaryButton type="primary" htmlType="submit">
          Add Restaurant
        </PrimaryButton>
      </Form.Item>
    </Form>
  );
};

export default AddRestaurantForm;
