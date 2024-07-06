import { USERROLE } from '@/types/User';

export type RegisterFieldType = {
  name?: string;
  email?: string;
  phone?: string;
  password?: string;
  remember?: string;
};

export type TRestaurantRegister = {
  name?: string;
  email?: string;
  phone?: string;
  password?: string;
  role: USERROLE;
};
