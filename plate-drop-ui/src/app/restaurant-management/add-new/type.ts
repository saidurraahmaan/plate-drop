export interface IAddRestaurantFormProps {
  onAddRestaurant: (values: IRestaurant) => void;
  className?: string;
}

export interface IRestaurant {
  name: string;
  cuisine: string;
  description: string;
  imageUrl: string;
}
