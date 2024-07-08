'use client';
import { Content } from 'antd/es/layout/layout';
import { AppstoreOutlined, SettingOutlined } from '@ant-design/icons';
import { Menu } from 'antd';
import React from 'react';
import Image from 'next/image';
import { AppHeader } from '@/components';
import type { MenuProps } from 'antd';
import styles from './style.module.css';
import logoImg from '../../../public/plate-drop-logo.png';
import { APP_ROUTES } from '@/constants';
import { useRouter } from 'next/navigation';

type MenuItem = Required<MenuProps>['items'][number];

const items: MenuItem[] = [
  {
    type: 'divider',
  },
  {
    type: 'divider',
  },
  {
    key: 'dashboard',
    label: 'Dashboard',
    icon: <AppstoreOutlined />,
    onClick: () => {},
  },
  {
    type: 'divider',
  },
  {
    key: 'restaurant',
    label: 'Manage Restaurant',
    icon: <SettingOutlined />,
    children: [
      {
        key: APP_ROUTES.ADD_RESTAURANT,
        label: 'Add Restaurant',
      },
      {
        key: APP_ROUTES.VIEW_RESTAURANT,
        label: 'View Restaurant',
      },
      { key: '3', label: 'Update Restaurant' },
    ],
  },
];

const RestaurantManageLayout = ({
  children,
}: Readonly<{ children: React.ReactNode }>) => {
  const router = useRouter();

  const onClick: MenuProps['onClick'] = (e) => {
    router.push(e.key);
  };

  return (
    <div className={styles.layoutContainer}>
      <div className={styles.menuContainer}>
        <Image src={logoImg} width={100} height={60} alt="logo" priority />
        <Menu
          theme="dark"
          onClick={onClick}
          style={{ width: '100%' }}
          defaultSelectedKeys={['1']}
          defaultOpenKeys={['restaurant']}
          mode="inline"
          items={items}
        />
      </div>
      <div className={styles.contentContainer}>
        <AppHeader shouldHideLogo={true} />
        <Content className={styles.content}>
          {children}
        </Content>
      </div>
    </div>
  );
};

export default RestaurantManageLayout;
