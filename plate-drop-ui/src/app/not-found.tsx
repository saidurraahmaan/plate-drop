'use client';
import React from 'react';
import { Button, Result } from 'antd';
import Link from 'next/link';
import { useRouter } from 'next/navigation';

const NotFound = () => {
  const router = useRouter();

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <Result
        status="404"
        title="404"
        subTitle="Sorry, the page you visited does not exist."
        extra={
          <>
            <Button type="primary" onClick={() => router.back()}>
              Go Back
            </Button>
            <Link href="/" passHref>
              <Button type="default" style={{ marginLeft: '10px' }}>
                Back Home
              </Button>
            </Link>
          </>
        }
      />
    </div>
  );
};
export default NotFound;
