'use client';
import React from 'react';
import { Button, Result } from 'antd';
import { AppError } from '@/types/Error';

interface ErrorPageProps {
  error: AppError;
  reset: () => void;
}

const Error = ({ error, reset }: ErrorPageProps) => (
  <Result
    status="500"
    title={error.message}
    extra={
      <Button type="primary" onClick={reset}>
        Try again
      </Button>
    }
  />
);
export default Error;
