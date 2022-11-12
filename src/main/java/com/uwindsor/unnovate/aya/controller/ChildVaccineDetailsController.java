package com.uwindsor.unnovate.aya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uwindsor.unnovate.aya.model.ChildVaccineDetails;
import com.uwindsor.unnovate.aya.repository.ChildVaccineDetailsRepository;

@RestController
public class ChildVaccineDetailsController {
	
	@Autowired
    private ChildVaccineDetailsRepository childVaccineDetailsRepository;

	@RequestMapping(
			  value = "/childvaccinedetails/create", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String createParentsDetails(@RequestBody String id) throws Exception {
		 //create ObjectMapper instance
		System.out.println("Inside create");
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON file and convert to a customer object
        ChildVaccineDetails customer = objectMapper.readValue(id, ChildVaccineDetails.class);

        //print customer details
        
        childVaccineDetailsRepository.save(customer);
        System.out.println(customer.toString());
	        return "Parent " +customer.getVaccineid() + " added successfully.";
	    }
	
	@RequestMapping(
			  value = "/childvaccinedetails/update", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String updateParentsDetails(@RequestBody String id) throws Exception {
		
		System.out.println("Inside update");
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      //read JSON file and convert to a customer object
      ChildVaccineDetails customer = objectMapper.readValue(id, ChildVaccineDetails.class);
         
      childVaccineDetailsRepository.save(customer);
      //print customer details
      System.out.println(customer.toString());
	        return "Hello World RESTful with Spring Boot:-  " +id;
	    }
	
	@RequestMapping(
			  value = "/childvaccinedetails/delete", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String deleteParentsDetails(@RequestBody String id) throws Exception {
		
		System.out.println("Inside delete functionality");
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      //read JSON file and convert to a customer object
      ChildVaccineDetails customer = objectMapper.readValue(id, ChildVaccineDetails.class);

      //print customer details
      System.out.println(customer.toString());
      childVaccineDetailsRepository.delete(customer);
	        return "Hello World RESTful with Spring Boot:-  " +id;
	    }
	
	@RequestMapping(
			  value = "/childvaccinedetails/read", 
			  method = RequestMethod.GET)
	@ResponseBody
	    public String readParentsDetails() throws Exception {
		System.out.println("Inside read");
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      List <ChildVaccineDetails> list = childVaccineDetailsRepository.findAll();
      //print customer details
      for(int i=0;i<list.size();i++)
      {
    	  ChildVaccineDetails cd = list.get(i);
    	  System.out.println("Parent name is :- "+cd.getChildid());
      }
      
      String jsonStr = objectMapper.writeValueAsString(list);
    		  return jsonStr;
	    }

}
