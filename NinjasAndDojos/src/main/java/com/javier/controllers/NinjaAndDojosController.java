package com.javier.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.models.Dojo;
import com.javier.models.Ninja;
import com.javier.services.NinjaAndDojosService;

@Controller
public class NinjaAndDojosController {
	private final NinjaAndDojosService service;
	
	public NinjaAndDojosController(NinjaAndDojosService service){
		this.service=service;		
	}
	
	@GetMapping ("/")
	public String index(){
		return "redirect:/dojos";	
	}
	
	@GetMapping ( value = "/dojos")
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model){
		List <Dojo> dojos = service.allDojos();
			
		model.addAttribute("dojos", dojos);
		
		return "index.jsp";	
	}
	
	@GetMapping ( value ="/ninjas")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model){
		List <Dojo> dojos = service.allDojos();
		Long exampleId = (long) 3;
		Dojo exampledojo = service.findDojoById(exampleId);
		
		model.addAttribute("dojos", dojos);
		model.addAttribute("dojo", exampledojo);
		
		return "ninja.jsp";	
	}
	
	
	
	
	
	
	@PostMapping ( "/newNinja" )
	public String makeNinja (@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}	
		service.createNinja(ninja);
		return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
	}
	
	
	
	
	
	
	
	@GetMapping ( value ="/dojos/{id}")
	public String ninjas(Model model, @PathVariable("id") Long id){
			
		List <Ninja> ninjas = service.allNinjasByDojo(id);
		Dojo dojo = service.findDojoById(id);
		
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		
		return "dojo_show.jsp";	
	}
	
	@PostMapping ("/dojos")
	public String makeDojo (@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		service.createDojo(dojo);
		return "redirect:/dojos";
	}
}
