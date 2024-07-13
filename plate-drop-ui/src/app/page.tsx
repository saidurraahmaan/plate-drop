// "use client"
import useStore from '@/store';
import React from 'react';

const Page = () => {
  const { userInfo } = useStore();
  console.log(userInfo);

  return <div>Page</div>;
};

export default Page;
