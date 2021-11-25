package com.javaspring.signinsignup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.signinsignup.model.Trip;
import com.javaspring.signinsignup.service.TripService;


@RestController
@RequestMapping(path="/trip")
public class TripController {

	@Autowired
	TripService tripService;
	
	@RequestMapping(value= {"/getAllTrips"},  method=RequestMethod.GET)
	public List<Trip> getAllTrips (){
		List<Trip> tripList = new ArrayList<>();
		tripList.addAll(tripService.getAllTrip());
		return tripList;
	}
	@PostMapping(path="/saveTrip", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveTrip(@RequestBody Trip trip) {
		return tripService.saveTrip(trip);
	}
}
