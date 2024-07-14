'use client';
import React from 'react';
import { Form, Input, Button, InputNumber } from 'antd';
import { IMenuFormValues } from './types';

const AddMenuForm: React.FC = () => {
  const [form] = Form.useForm();

  const onFinish = (values: IMenuFormValues) => {
    console.log('Success:', values);
    // Handle form submission logic here
  };

  const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <Form
      form={form}
      name="addMenuForm"
      layout="vertical"
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
      initialValues={{
        name: '',
        description: '',
        price: 0,
        imageUrl: '',
      }}
    >
      <Form.Item<IMenuFormValues>
        label="Menu Name"
        name="name"
        rules={[{ required: true, message: 'Please input the menu name!' }]}
      >
        <Input />
      </Form.Item>

      <Form.Item<IMenuFormValues>
        label="Description"
        name="description"
        rules={[{ required: true, message: 'Please input the description!' }]}
      >
        <Input.TextArea rows={4} />
      </Form.Item>

      <Form.Item<IMenuFormValues>
        label="Price"
        name="price"
        rules={[{ required: true, message: 'Please input the price!' }]}
      >
        <InputNumber
          min={0}
          formatter={(value: string | number | undefined) =>
            `$ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')
          }
          parser={(value: string | undefined) =>
            value ? value.replace(/\$\s?|(,*)/g, '') : ''
          }
          style={{ width: '100%' }}
        />
      </Form.Item>

      <Form.Item<IMenuFormValues>
        label="Image URL"
        name="imageUrl"
        rules={[{ required: true, message: 'Please input the image URL!' }]}
      >
        <Input />
      </Form.Item>

      <Form.Item>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form.Item>
    </Form>
  );
};

export default AddMenuForm;
