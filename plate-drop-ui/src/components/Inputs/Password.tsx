import React from 'react';
import { Input, InputProps } from 'antd';

const PasswordInput: React.FC<InputProps> = ({ ...rest }) => {
  return <Input.Password {...rest} />;
};

export default PasswordInput;
