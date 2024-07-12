export interface IAddRestaurantFormProps {
  onAddRestaurant: (values: IRestaurantFieldType) => void;
  className?: string;
}

export interface IRestaurantFieldType {
  name: string;
  cuisine: string;
  description: string;
  imageUrl: string;
}

export interface IRestaurant {
  id: number;
  name: string;
  cuisine: string;
  description: string;
  imageUrl: string;
  rating: number;
}
