package com.example.demo.controller;

import java.awt.SecondaryLoop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

import com.example.demo.model.Podaci;
import com.example.demo.model.SecondGrafikData;
import com.example.demo.repository.UserRepository;

//@RestController    // This means that this class is a RestController

@RestController
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	//@PutMapping (path="/add") // This means URL's start with /add/{data} (after Application path)
	@PutMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String ime
			, @RequestParam String prezime, @RequestParam String adresa ) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Podaci n = new Podaci();
		n.setIme(ime);
		n.setPrezime(prezime);
		n.setAdresa(adresa);
		userRepository.save(n);
		
		return "Saved";
	}
	
	@PostMapping(path="/update")
	public String update()
	{
		
		return "Update done";
	}

	@GetMapping(path="/demo/all")
	public @ResponseBody Iterable<Podaci> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	
	@GetMapping(path="readAll")
	public @ResponseBody List<Podaci> getAll()
	{
		List<Podaci> listaKorisnika=new ArrayList<>();
		userRepository.findAll().forEach(listaKorisnika::add);
		return listaKorisnika;
	}
	
	@GetMapping(path="/findOne")
	public Podaci korisnik(@RequestParam String ime)
	{
		Podaci objekat=new Podaci();
		
		objekat= userRepository.findByIme(ime);
		return objekat;
		
		
	}
	
	@RequestMapping(path="/findId/{id}")
	public List<Podaci> korisnikId(@PathVariable int id)
	
	
	{
		System.out.println("id je "+id);
		List<Podaci> lista=new ArrayList<>();
		try {
			lista.add(userRepository.findById(id).get());
		} catch (Exception e) {
			lista.clear();
		}
		
		return lista;
		
	}
	
	@PutMapping("/demo/{id}")
	public String updateKorisnik(@PathParam(value = "{id}")  Integer id,@RequestBody Podaci korisnik)
	{
		userRepository.save(korisnik);
		return "Update done";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteKorisnik(@PathVariable int id)
	{
		System.out.println(id);
		userRepository.deleteById(id);
		return "Delete done";
	}
	
	
	
	
	
	//Data for highchart for AJAX REQUEST
	@CrossOrigin("*")
	@RequestMapping("/grafik")
	public String grafik()
	{
		return "Belgrade,1.52|Vienna,1.73|Paris,2.24|London,8.13";
	}
	
	
	
	//Data for highchart for AJAX REQUEST
	@CrossOrigin("*")
	@RequestMapping("/grafikSecond")
	public List<SecondGrafikData> grafikSecond()
	{
		List<SecondGrafikData> listaData=new ArrayList<>();
		listaData.add(new SecondGrafikData("Installation",  new ArrayList<>(Arrays.asList(43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175))));
		listaData.add(new SecondGrafikData("Manufacturing", new ArrayList<>(Arrays.asList(24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434))));
		listaData.add(new SecondGrafikData("Sales & Distribution",  new ArrayList<>(Arrays.asList(11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387))));
		listaData.add(new SecondGrafikData("Project Development",  new ArrayList<>(Arrays.asList(null, null, 7988, 12169, 15112, 22452, 34400, 34227))));
		listaData.add(new SecondGrafikData("Other",  new ArrayList<>(Arrays.asList(12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111))));

	        		
	    return listaData;
	}
	
	@GetMapping(path="/test")
	public String hello()
	{
		return "Hello";
		
	}
	
	
}