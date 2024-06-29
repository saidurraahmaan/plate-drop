import { APP_ROUTES } from '@/constants';

export const getUnAuthorizedNavItems: unAuthorizedNavContent[] = [
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
