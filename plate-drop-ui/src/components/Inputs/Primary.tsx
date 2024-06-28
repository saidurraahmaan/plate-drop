import React from 'react';
import { Input, InputProps } from 'antd';

const PrimaryInput: React.FC<InputProps> = ({ ...rest }) => {
  return <Input {...rest} />;
};

export default PrimaryInput;
