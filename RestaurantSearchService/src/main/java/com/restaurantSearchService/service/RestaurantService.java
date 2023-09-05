package com.restaurantSearchService.service;

import java.util.List;
import java.util.Optional;

import com.restaurantSearchService.entity.RestaurantSearch;

import com.restaurantSearchService.exception.ResourceNotFoundException;

public interface RestaurantService {

	List<RestaurantSearch> getRestaurant();

	List<RestaurantSearch> findByRestName(String restName);

	List<RestaurantSearch> findByLocation(String location);

	RestaurantSearch findByRestCuisine(String restCuisine);

	RestaurantSearch findByRating(int rating);

	RestaurantSearch findByDistance(int distance);

	RestaurantSearch getByRestBudget(long restBudget);

	RestaurantSearch addRestaurant(RestaurantSearch restaurantSearch);

	void deleteRestaurant(long parseLong);

	RestaurantSearch getRestaurantSearchByRestId(long restId);

	RestaurantSearch updateRestaurant(RestaurantSearch restaurantSearch, long restId) throws ResourceNotFoundException;

}
