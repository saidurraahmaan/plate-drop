import { USERROLE } from '@/types/User';

export type CustomerRegisterFieldType = {
  name?: string;
  email?: string;
  phone?: string;
  password?: string;
  remember?: string;
};

export type TCustomerRegister = {
  name?: string;
  email?: string;
  phone?: string;
  password?: string;
  role: USERROLE;
};
