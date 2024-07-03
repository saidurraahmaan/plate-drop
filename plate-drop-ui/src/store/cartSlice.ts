import { IUser } from '@/types/User';
import { IJWTToken } from '@/types/token';
import { StateCreator } from 'zustand';

interface ICartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

export interface ICartSliceState {
  cartItems: ICartItem[];
  totalCartItems: number;
  addToCart: (item: ICartItem) => void;
  removeFromCart: (id: number) => void;
  clearCart: () => void;
}

export const createCartSlice: StateCreator<ICartSliceState> = (set) => ({
  cartItems: [],
  totalCartItems: 0,
  addToCart: (item) =>
    set((state) => {
      const existingItem = state.cartItems.find((i) => i.id === item.id);
      let newItems;
      if (existingItem) {
        newItems = state.cartItems.map((i) =>
          i.id === item.id ? { ...i, quantity: i.quantity + item.quantity } : i
        );
      } else {
        newItems = [...state.cartItems, item];
      }
      const newTotal = newItems.reduce(
        (acc, i) => acc + i.price * i.quantity,
        0
      );
      return { items: newItems, totalCartItems: newTotal };
    }),
  removeFromCart: (id) =>
    set((state) => {
      const newItems = state.cartItems.filter((i) => i.id !== id);
      const newTotal = newItems.reduce(
        (acc, i) => acc + i.price * i.quantity,
        0
      );
      return { items: newItems, totalCartItems: newTotal };
    }),
  clearCart: () => set({ cartItems: [], totalCartItems: 0 }),
});
