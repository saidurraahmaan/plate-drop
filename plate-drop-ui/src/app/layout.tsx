import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import { AntdRegistry } from '@ant-design/nextjs-registry';
import { Layout } from 'antd';
import { Content, Footer } from 'antd/es/layout/layout';
import { AppHeader } from '@/components';
import './globals.css';
import styles from './app.module.css';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Plate Drop',
  description: 'Order your food now',
};

const RootLayout = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return (
    <html lang="en">
      <head>
        <link rel="icon" href="/plate-drop-logo.png" />
      </head>
      <body className={inter.className}>
        <AntdRegistry>
          <Layout>
            <AppHeader />
            <div className="hidden">divider</div>
            <Content style={{ padding: '0 48px' }}>
              <div className={styles.main_container}>{children}</div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>
              ©{new Date().getFullYear()} Created by Saidur Rahman
            </Footer>
          </Layout>
        </AntdRegistry>
      </body>
    </html>
  );
};

export default RootLayout;
