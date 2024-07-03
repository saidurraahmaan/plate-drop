import { IUser } from '@/types/User';
import { IJWTToken } from '@/types/token';
import { StateCreator } from 'zustand';

export interface IAuthSliceState {
  userInfo: IUser | null;
  token: IJWTToken | null;
  login: (userInfo: IUser, token: IJWTToken) => void;
  clearAuth: () => void;
}

export const createAuthSlice: StateCreator<IAuthSliceState> = (set) => ({
  userInfo: null,
  token: null,
  login: (userInfo, token) => set({ userInfo, token }),
  clearAuth: () => set({ userInfo: null, token: null }),
});
