'use client';
import React from 'react';
import { Menu } from 'antd';
import { AppstoreOutlined, SettingOutlined } from '@ant-design/icons';
import type { MenuProps } from 'antd';
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

const LeftMenu = () => {
  const router = useRouter();

  const onClick: MenuProps['onClick'] = (e) => {
    router.push(e.key);
  };

  return (
    <Menu
      theme="dark"
      onClick={onClick}
      style={{ width: '100%' }}
      defaultSelectedKeys={['1']}
      defaultOpenKeys={['restaurant']}
      mode="inline"
      items={items}
    />
  );
};

export default LeftMenu;
