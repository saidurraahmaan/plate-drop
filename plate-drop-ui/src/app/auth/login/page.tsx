'use client';
import React from 'react';
import type { FormProps } from 'antd';
import { Checkbox, Form, message } from 'antd';
import styles from './login.module.css';
import { PasswordInput, PrimaryButton, PrimaryInput } from '@/components';
import fetchInstance from '@/libs/fetchApi';
import { APP_ROUTES, AUTH_API } from '@/constants';
import useStore from '@/store';
import { useRouter } from 'next/navigation';
import { IJWTToken } from '@/types/token';
import { TLoginFieldType } from './types';
import { IUser } from '@/types/User';

const Login: React.FC = () => {

  const router = useRouter();
  const {login} = useStore();



  const onFinish: FormProps<TLoginFieldType>['onFinish'] = async (values) => {
    try {
      const data = await fetchInstance.post<{user:IUser; token:IJWTToken}, TLoginFieldType>(
        AUTH_API.SIGNIN,
        values
      );
      if(data){
        login(data.user,data.token)
        message.success('Login Success');
        router.push(APP_ROUTES.HOME)
        return;
      }
    } catch (error) {
      const err = error as Error;
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
