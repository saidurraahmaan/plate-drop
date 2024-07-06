import React from 'react';
import { Content } from 'antd/es/layout/layout';
import { AppHeader } from '@/components';

const AuthLayout = ({ children }: Readonly<{ children: React.ReactNode }>) => {
  return (
    <>
      <AppHeader />
      <Content className="main-content">
        <div className="main-container">{children}</div>
      </Content>
    </>
  );
};

export default AuthLayout;
