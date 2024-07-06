export interface IUser {
  name: string | undefined;
  email: string | undefined;
  phone: string | undefined;
  role: USERROLE;
}

export enum USERROLE {
  CUSTOMER = 'CUSTOMER',
  RESTAURANT = 'RESTAURANT',
  DELIVERYPERSON = 'DELIVERY_PERSON',
}
