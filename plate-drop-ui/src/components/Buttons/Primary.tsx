import React from 'react';
import { Button, ButtonProps } from 'antd';

const PrimaryButton: React.FC<ButtonProps> = ({ children, ...rest }) => {
  return (
    <Button type="primary" {...rest}>
      {children}
    </Button>
  );
};

export default PrimaryButton;
