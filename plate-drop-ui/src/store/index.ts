// src/store/index.ts
import { create } from 'zustand';
import { IAuthSliceState, createAuthSlice } from './authSlice';

type StoreState = IAuthSliceState;

const useStore = create<StoreState>()((...a) => ({
  ...createAuthSlice(...a),
}))


export default useStore;

