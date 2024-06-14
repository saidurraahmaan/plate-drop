import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import { AntdRegistry } from '@ant-design/nextjs-registry';
import { Layout, Menu, theme } from 'antd';
import { Header, Content, Footer } from 'antd/es/layout/layout';

import './globals.css';
import './app.css';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Plate Drop',
  description: 'Order your food now',
};

const items = new Array(15).fill(null).map((_, index) => ({
  key: index + 1,
  label: `nav ${index + 1}`,
}));

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <head>
        <link rel="icon" href="plate-drop-logo.png" />
      </head>
      <body className={inter.className}>
        <AntdRegistry>
          <Layout>
            <Header style={{ display: 'flex', alignItems: 'center' }}>
              <div className="demo-logo" />
              <Menu
                theme="dark"
                mode="horizontal"
                defaultSelectedKeys={['2']}
                items={items}
                style={{ flex: 1, minWidth: 0 }}
              />
            </Header>
            <div className="hidden">divider</div>
            <Content style={{ padding: '0 48px' }}>
              <div className="main-container">{children}</div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>
              ©{new Date().getFullYear()} Created by Saidur Rahman
            </Footer>
          </Layout>
        </AntdRegistry>
      </body>
    </html>
  );
}
