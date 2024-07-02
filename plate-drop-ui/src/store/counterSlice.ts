import { StateCreator } from 'zustand';

export interface IAuthSliceState {
  userInfo: IUser | null;
  token: string | null;
  setUserInfo: (userInfo: {
    name: string;
    email: string;
    phone: string;
  }) => void;
  setToken: (token: string) => void;
  clearUser: () => void;
}

export const createAuthSlice: StateCreator<IAuthSliceState> = (set) => ({
  userInfo: null,
  token: null,
  setUserInfo: (userInfo) => set({ userInfo }),
  setToken: (token) => set({ token }),
  clearUser: () => set({ userInfo: null, token: null }),
});
