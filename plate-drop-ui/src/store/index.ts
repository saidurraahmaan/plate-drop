// src/store/index.ts
import { create } from 'zustand';
import { persist } from 'zustand/middleware';
import { IAuthSliceState, createAuthSlice } from './authSlice';
import { ICartSliceState, createCartSlice } from './cartSlice';

type StoreState = IAuthSliceState & ICartSliceState;

const persistConfig = {
  name: 'plate-drop-storage',
  partialize: (state: StoreState) => ({
    token: state.token,
    userInfo: state.userInfo,
    cartItems: state.cartItems,
  }),
};

const useStore = create<StoreState>()(
  persist(
    (...a) => ({
      ...createAuthSlice(...a),
      ...createCartSlice(...a),
    }),
    persistConfig
  )
);

export default useStore;
