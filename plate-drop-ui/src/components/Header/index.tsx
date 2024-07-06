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
import { APP_ROUTES } from '@/constants';

interface AppHeaderProps {
  shouldHideLogo?: boolean;
}

const AppHeader: React.FC<AppHeaderProps> = ({ shouldHideLogo }) => {
  const router = useRouter();
  const navItems = getUnAuthorizedNavItems.map((ele) => ({
    key: ele.key,
    label: ele.label,
    onClick: () => router.push(ele.navigateTo),
  }));
  const { logout, isLoggedIn } = useStore();

  const handleLogout = () => {
    logout();
    router.push(APP_ROUTES.LOGIN);
  };

  const userProfileItems: MenuProps['items'] = [
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

  const registrationItems: MenuProps['items'] = [
    {
      key: 'customer',
      label: 'As Customer',
      onClick: () => router.push(APP_ROUTES.CUSTOMER_REGISTRATION),
    },
    {
      key: 'restaurant',
      label: 'As Restaurant Owner',
      onClick: () => router.push(APP_ROUTES.RESTAURANT_REGISTRATION),
    },
    {
      key: 'delivery',
      label: 'As Delivery Person',
      onClick: () => router.push(APP_ROUTES.DELIVERY_REGISTRATION),
    },
  ];

  return (
    <>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div className={styles.nav_container}>
          <div className={`d-flex ${shouldHideLogo ? styles.hidden : ''}`}>
            <Image src={logoImg} width={100} height={60} alt="logo" priority />
          </div>
          <div className={styles.nav_right}>
            {isLoggedIn ? (
              <Dropdown menu={{ items: userProfileItems }} placement="bottom">
                <Avatar style={{ marginLeft: 16 }} icon={<UserOutlined />} />
              </Dropdown>
            ) : (
              <>
                <Dropdown
                  menu={{ items: registrationItems }}
                  placement="bottom"
                >
                  <span className={styles.register_text}>Register</span>
                </Dropdown>
                <Menu
                  theme="dark"
                  mode="horizontal"
                  items={navItems}
                  disabledOverflow
                  style={{ flex: 'auto', minWidth: 0 }}
                />
              </>
            )}
          </div>
        </div>
      </Header>
    </>
  );
};

export default AppHeader;
