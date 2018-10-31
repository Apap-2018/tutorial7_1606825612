package com.apap.tutorial7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.CarService;


@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;

		@PostMapping(value = "/add")
		private CarModel addCarSubmit(@RequestBody CarModel car) {
			return carService.addCar(car);
		}
		
		@GetMapping(value = "/{carId}")
		private CarModel viewcar(@PathVariable ("carId") long carId, Model model) {
			CarModel car =  carService.getCar(carId);
			car.getDealer().setListCar(null);
			car.setDealer(car.getDealer());
			return car;
		}
		
		@DeleteMapping(value = "/delete/{carId}")
		private String deletecar(@PathVariable ("carId") long id, Model model) {
			CarModel car = carService.getCar(id);
			carService.deleteCar(car);
			return "Success";
		}
		
		@PutMapping(value = "/{id}")
		private String updatecarSubmit(@PathVariable (value = "id") long id,
										@RequestParam("brand") String brand,
										@RequestParam("type") String type,
										@RequestParam("price") long price,
										@RequestParam("amount") Integer amount,
										@RequestParam("dealerId") long dealerId) {
			CarModel car = (CarModel) carService.getCar(id);
			if(car.equals(null)) {
				return "Couldn't find your car";
			}
			car.setBrand(brand);
			car.setType(type);
			car.setPrice(price);
			car.setAmount(amount);
			carService.updateCar(id, car);
			return "update success";
			
		}
		
		@GetMapping()
		private List<CarModel> viewAllcar(Model model) {
			return carService.findAll();
		}
}
