package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.CarModel;

public interface CarService {
	CarModel addCar(CarModel car);
	
	List<CarModel> getListCarByDealerIdSortByPrice(Long id);
	
	void deleteCar(CarModel car);
	
	void updateCar(long id, CarModel carModel);
	
	CarModel getCar(long id);
	
	List<CarModel> findAll();
}