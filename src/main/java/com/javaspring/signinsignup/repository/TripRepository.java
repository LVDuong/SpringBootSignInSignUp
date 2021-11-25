package com.javaspring.signinsignup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.signinsignup.model.Trip;


@Repository
public interface TripRepository extends CrudRepository<Trip, String>{

}
