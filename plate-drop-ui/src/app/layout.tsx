import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import { AntdRegistry } from '@ant-design/nextjs-registry';
import { Layout } from 'antd';
import './globals.css';

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
          <Layout>{children}</Layout>
          {/* <Footer style={{ textAlign: 'center', width: '100%' }}>
          ©{new Date().getFullYear()} Created by Saidur Rahman
        </Footer> */}
        </AntdRegistry>
      </body>
    </html>
  );
};

export default RootLayout;
