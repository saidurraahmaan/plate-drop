import { IUser } from '@/types/User';
import { IJWTToken } from '@/types/Token';
import { StateCreator } from 'zustand';

export interface IAuthSliceState {
  isLoggedIn: boolean;
  userInfo: IUser | null;
  login: (userInfo: IUser) => void;
  logout: () => void;
  clearAuth: () => void;
}

export const createAuthSlice: StateCreator<IAuthSliceState> = (set, get) => ({
  isLoggedIn: false,
  userInfo: null,
  login: (userInfo) => set({ userInfo, isLoggedIn: true }),
  logout: () => set({ userInfo: null, isLoggedIn: false }),
  clearAuth: () => set({ userInfo: null }),
});
