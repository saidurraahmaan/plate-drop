import { APP_ROUTES } from '@/constants';
import {TUnAuthorizedNavContent} from './types'

export const getUnAuthorizedNavItems: TUnAuthorizedNavContent[] = [
  {
    key: 1,
    label: 'Register',
    navigateTo: APP_ROUTES.REGISTRATION,
  },
  {
    key: 2,
    label: 'Login',
    navigateTo: APP_ROUTES.LOGIN,
  },
];
