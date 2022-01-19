package com.abhishek.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.springmvcboot.model.Alien;


@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path = "aliens",produces= {"application/xml"})
	//@ResponseBody
	public List<Alien> getAliens(Model m)
	{
		List<Alien> aliens = repo.findAll();
		
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	//@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) 
	{
		Alien alien = repo.findById(aid).orElse(new Alien(0,""));
		
		return alien;
	}
	
	@PostMapping(path = "alien", consumes = {"application/json"})
	//@ResponseBody
	public Alien getAlien(@RequestBody Alien alien) 
	{
		repo.save(alien);
		
		return alien;
	}
}
