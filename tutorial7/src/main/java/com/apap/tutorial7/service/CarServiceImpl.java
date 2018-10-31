package com.apap.tutorial7.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	

	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}
	
	@Override
	public List<CarModel> getListCarByDealerIdSortByPrice(Long id) {
		return carDb.findByDealerIdOrderByPriceAsc(id);
	}
	
	@Override
	public void deleteCar(CarModel car) {
		carDb.delete(car);
	}
	
	@Override
	public CarModel getCar(long id) {
		return carDb.findById(id).get();
		
	}
	
	@Override
	public void updateCar(long id, CarModel newCar) {
		CarModel diUpdated = carDb.getOne(id);
		diUpdated.setBrand(newCar.getBrand());
		diUpdated.setType(newCar.getType());
		diUpdated.setPrice(newCar.getPrice());
		diUpdated.setAmount(newCar.getAmount());
		carDb.save(diUpdated);
	}

	@Override
	public List<CarModel> findAll() {
		// TODO Auto-generated method stub
		return carDb.findAll();
	}
}
