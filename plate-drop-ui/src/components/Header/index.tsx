'use client';
import React from 'react';
import { useRouter } from 'next/navigation';
import { Header } from 'antd/es/layout/layout';
import Image from 'next/image';
import { Menu } from 'antd';
import { getUnAuthorizedNavItems } from '@/app/utils';
import styles from './header.module.css';

const AppHeader = () => {
  const router = useRouter();
  const navItems = getUnAuthorizedNavItems.map((ele) => ({
    ...ele,
    onClick: () => router.push(ele.navigateTo),
  }));
  return (
    <>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div className={styles.nav_container}>
          <div className="d-flex">
            <Image
              src={'/plate-drop-logo.png'}
              width={100}
              height={60}
              alt="logo"
            />
          </div>
          <div>
            <Menu
              theme="dark"
              mode="horizontal"
              items={navItems}
              disabledOverflow
              style={{ flex: 'auto', minWidth: 0 }}
            />
          </div>
        </div>
      </Header>
    </>
  );
};

export default AppHeader;
