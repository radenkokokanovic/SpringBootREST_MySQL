package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Podaci;

public interface UserRepository extends CrudRepository<Podaci, Integer> {
	
	Podaci findByIme(String ime);


}