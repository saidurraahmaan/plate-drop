import { StateCreator } from 'zustand';

export interface AuthSliceState {
  userInfo: { name: string; email: string; phone: string } | null;
  token: string | null;
  setUserInfo: (userInfo: {
    name: string;
    email: string;
    phone: string;
  }) => void;
  setToken: (token: string) => void;
  clearUser: () => void;
}

export const createAuthSlice: StateCreator<AuthSliceState> = (set) => ({
  userInfo: null,
  token: null,
  setUserInfo: (userInfo) => set({ userInfo }),
  setToken: (token) => set({ token }),
  clearUser: () => set({ userInfo: null, token: null }),
});
