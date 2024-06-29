// src/store/index.ts
import { create } from 'zustand';
import { AuthSliceState, createAuthSlice } from './authSlice';

type StoreState = AuthSliceState;

const useStore = create<StoreState>((set, get) => ({
  ...createAuthSlice(set, get),
}));

export default useStore;
