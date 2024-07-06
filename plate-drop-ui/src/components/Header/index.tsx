'use client';
import React from 'react';
import { useRouter } from 'next/navigation';
import { Header } from 'antd/es/layout/layout';
import Image from 'next/image';
import { Avatar, Dropdown, Menu } from 'antd';
import type { MenuProps } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { getUnAuthorizedNavItems } from '@/app/utils';
import logoImg from '../../../public/plate-drop-logo.png';
import styles from './header.module.css';
import useStore from '@/store';

const AppHeader = () => {
  const router = useRouter();
  const navItems = getUnAuthorizedNavItems.map((ele) => ({
    key: ele.key,
    label: ele.label,
    onClick: () => router.push(ele.navigateTo),
  }));
  const { logout, isLoggedIn } = useStore();

  const handleLogout = () => {
    logout();
    router.push('/login');
  };

  const items: MenuProps['items'] = [
    {
      key: 'profile',
      label: 'Profile Settings',
      onClick: () => router.push('/profile'),
    },
    {
      key: 'logout',
      label: 'Logout',
      onClick: handleLogout,
    },
  ];

  return (
    <>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div className={styles.nav_container}>
          <div className="d-flex">
            <Image src={logoImg} width={100} height={60} alt="logo" priority />
          </div>
          <div>
            {!isLoggedIn && (
              <Menu
                theme="dark"
                mode="horizontal"
                items={navItems}
                disabledOverflow
                style={{ flex: 'auto', minWidth: 0 }}
              />
            )}
            {isLoggedIn && (
              <Dropdown menu={{ items }} placement="bottomRight">
                <Avatar style={{ marginLeft: 16 }} icon={<UserOutlined />} />
              </Dropdown>
            )}
          </div>
        </div>
      </Header>
    </>
  );
};

export default AppHeader;
