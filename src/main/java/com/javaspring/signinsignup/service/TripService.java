package com.javaspring.signinsignup.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.signinsignup.model.Trip;
import com.javaspring.signinsignup.repository.TripRepository;


@Service
public class TripService {

	@Autowired
	TripRepository tripRepository;
	public Collection<? extends Trip> getAllTrip() {
		List<Trip> tripList = new ArrayList<>();
		tripRepository.findAll().forEach(tripList::add);
		return tripList;
	}
	public String saveTrip(Trip trip) {
		Trip savedTrip = tripRepository.save(trip);
		if(savedTrip!=null) {
			return "Saved : id - " + savedTrip.getId();
		} else {
			return "Failed : id - " + trip.getId();
		}
	}

}
