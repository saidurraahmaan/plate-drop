import { Content } from 'antd/es/layout/layout';
import React from 'react';
import Image from 'next/image';
import { AppHeader } from '@/components';
import styles from './style.module.css';
import logoImg from '../../../public/plate-drop-logo.png';
import LeftMenu from './left-menu';

const RestaurantManageLayout = ({
  children,
}: Readonly<{ children: React.ReactNode }>) => {
  return (
    <div className={styles.layoutContainer}>
      <div className={styles.menuContainer}>
        <Image src={logoImg} width={100} height={60} alt="logo" priority />
        <LeftMenu />
      </div>
      <div className={styles.contentContainer}>
        <AppHeader shouldHideLogo={true} />
        <Content className={styles.content}>{children}</Content>
      </div>
    </div>
  );
};

export default RestaurantManageLayout;
