import { IUser } from '@/types/User';
import { IJWTToken } from '@/types/Token';
import { StateCreator } from 'zustand';

export interface IAuthSliceState {
  isLoggedIn: boolean;
  userInfo: IUser | null;
  token: IJWTToken | null;
  login: (userInfo: IUser, token: IJWTToken) => void;
  logout: () => void;
  clearAuth: () => void;
  getToken: () => IJWTToken | null;
}

export const createAuthSlice: StateCreator<IAuthSliceState> = (set, get) => ({
  isLoggedIn: false,
  userInfo: null,
  token: null,
  login: (userInfo, token) => set({ userInfo, token, isLoggedIn: true }),
  logout: () => set({ userInfo: null, token: null, isLoggedIn: false }),
  clearAuth: () => set({ userInfo: null, token: null }),
  getToken: () => get().token,
});
