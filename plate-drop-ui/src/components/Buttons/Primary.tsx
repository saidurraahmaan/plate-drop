import React from 'react';
import { Button, ButtonProps } from 'antd';

const PrimaryButton: React.FC<ButtonProps> = ({ children }) => {
  return <Button type="primary">{children}</Button>;
};

export default PrimaryButton;
