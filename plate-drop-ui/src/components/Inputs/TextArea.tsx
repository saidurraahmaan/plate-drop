// components/AppTextArea.tsx
import React from 'react';
import { Input } from 'antd';

const { TextArea } = Input;

interface TextAreaComponentProps {
  value?: string;
  onChange?: (event: React.ChangeEvent<HTMLTextAreaElement>) => void;
  placeholder?: string;
  rows?: number;
}

const AppTextArea: React.FC<TextAreaComponentProps> = ({ ...rest }) => {
  return <TextArea {...rest} />;
};

export default AppTextArea;
