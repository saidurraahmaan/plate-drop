'use client';
import React from 'react';
import { Form, message } from 'antd';
import type { FormProps } from 'antd';
import styles from './register.module.css';
import { PasswordInput, PrimaryButton, PrimaryInput } from '@/components';
import fetchInstance from '@/libs/fetchClient';
import { AUTH_API, APP_ROUTES } from '@/constants';
import { useRouter } from 'next/navigation';
import { CustomerRegisterFieldType, TCustomerRegister } from './types';
import { USERROLE } from '@/types/User';

const Register = () => {
  const router = useRouter();

  const onFinish: FormProps<CustomerRegisterFieldType>['onFinish'] = async (
    values
  ) => {
    const data: TCustomerRegister = {
      name: values.name,
      email: values.email,
      phone: values.phone,
      password: values.password,
      role: USERROLE.CUSTOMER,
    };

    try {
      await fetchInstance.post<void, CustomerRegisterFieldType>(
        AUTH_API.SIGNUP,
        data
      );
      message.success('Registration successful!');
      router.push(APP_ROUTES.LOGIN);
    } catch (error) {
      console.error('Failed:', error);
      message.error('Registration failed. Please try again.');
    }
  };

  const onFinishFailed: FormProps<CustomerRegisterFieldType>['onFinishFailed'] =
    (errorInfo) => {
      console.log('Failed:', errorInfo);
    };

  return (
    <div className={styles.register_container}>
      <div className="my-4 fw-bold">Register</div>
      <div>
        <Form
          name="registration"
          labelCol={{ span: 8 }}
          wrapperCol={{ span: 16 }}
          style={{ maxWidth: 600 }}
          initialValues={{ remember: true }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
        >
          <Form.Item<CustomerRegisterFieldType>
            label="Full Name"
            name="name"
            rules={[{ required: true, message: 'Please input your name!' }]}
          >
            <PrimaryInput />
          </Form.Item>

          <Form.Item<CustomerRegisterFieldType>
            label="Email"
            name="email"
            rules={[{ required: true, message: 'Please input your email!' }]}
          >
            <PrimaryInput />
          </Form.Item>
          <Form.Item<CustomerRegisterFieldType>
            label="Phone"
            name="phone"
            rules={[
              { required: true, message: 'Please input your phone number!' },
            ]}
          >
            <PrimaryInput />
          </Form.Item>

          <Form.Item<CustomerRegisterFieldType>
            label="Password"
            name="password"
            rules={[{ required: true, message: 'Please input your password!' }]}
          >
            <PasswordInput />
          </Form.Item>

          <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
            <PrimaryButton htmlType="submit">Submit</PrimaryButton>
          </Form.Item>
        </Form>
      </div>
    </div>
  );
};

export default Register;
