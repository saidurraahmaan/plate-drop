'use client';
import React from 'react';
import { Button, Result } from 'antd';

const Error = () => (
  <Result
    status="500"
    title="Sorry"
    subTitle="something went wrong."
    extra={<Button type="primary">Back Home</Button>}
  />
);

export default Error;
