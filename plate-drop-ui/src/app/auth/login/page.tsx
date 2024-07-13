'use client';
import React from 'react';
import type { FormProps } from 'antd';
import { Checkbox, Form, message } from 'antd';
import { useRouter } from 'next/navigation';
import { PasswordInput, PrimaryButton, PrimaryInput } from '@/components';
import { APP_ROUTES, AUTH_API } from '@/constants';
import fetchInstance from '@/libs/fetchClient';
import { USERROLE } from '@/types/User';
import { TLoginFieldType } from './types';
import styles from './login.module.css';
import { IUser } from '@/types/User';
import useStore from '@/store';
import { AppError } from '@/types/Error';

const Login: React.FC = () => {
  const router = useRouter();
  const { login } = useStore();

  const getRedirectRoute = (role: USERROLE) => {
    switch (role) {
      case USERROLE.DELIVERYPERSON:
        return '';
      case USERROLE.RESTAURANT:
        return APP_ROUTES.RESTAURANT_MANAGEMENT;
      default:
        return APP_ROUTES.HOME;
    }
  };

  const onFinish: FormProps<TLoginFieldType>['onFinish'] = async (values) => {
    try {
      const data = await fetchInstance.post<IUser, TLoginFieldType>(
        AUTH_API.SIGNIN,
        values
      );
      if (data) {
        login(data);
        message.success('Login Success');
        router.push(getRedirectRoute(data.role));
        return;
      }
    } catch (error) {
      const err = error as AppError;
      message.error(err.message);
    }
  };

  const onFinishFailed: FormProps<TLoginFieldType>['onFinishFailed'] = (
    errorInfo
  ) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <div className={styles.login_container}>
      <div className="my-4 fw-bold">Login with your credentials</div>
      <div>
        <Form
          labelCol={{ span: 8 }}
          wrapperCol={{ span: 16 }}
          style={{ maxWidth: 600 }}
          initialValues={{ remember: true }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
        >
          <Form.Item<TLoginFieldType>
            label="Email"
            name="email"
            rules={[{ required: true, message: 'Please input your email!' }]}
          >
            <PrimaryInput />
          </Form.Item>

          <Form.Item<TLoginFieldType>
            label="Password"
            name="password"
            rules={[{ required: true, message: 'Please input your password!' }]}
          >
            <PasswordInput />
          </Form.Item>

          <Form.Item<TLoginFieldType>
            name="remember"
            valuePropName="checked"
            wrapperCol={{ offset: 8, span: 16 }}
          >
            <Checkbox>Remember me</Checkbox>
          </Form.Item>

          <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
            <PrimaryButton htmlType="submit">Submit</PrimaryButton>
          </Form.Item>
        </Form>
      </div>
    </div>
  );
};

export default Login;
