package com.example.restaurantms.services;

import com.example.restaurantms.entities.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> getAll();

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id, Restaurant newRestaurant);

    String deleteRestaurant(int id);

}