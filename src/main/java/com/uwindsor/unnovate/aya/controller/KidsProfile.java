package com.uwindsor.unnovate.aya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uwindsor.unnovate.aya.model.ChildDetails;
import com.uwindsor.unnovate.aya.repository.ChildDetailsRepository;

@RestController
public class KidsProfile {
	
	@Autowired
    private ChildDetailsRepository childRepository;

	@RequestMapping(
			  value = "/kidsprofile/create", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String createKidsDetails(@RequestBody String id) throws Exception {
		 //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON file and convert to a customer object
        ChildDetails customer = objectMapper.readValue(id, ChildDetails.class);

        //print customer details
        
        childRepository.save(customer);
        System.out.println(customer.toString());
	        return "Hello World RESTful with Spring Boot:-  " +id;
	    }
	
	@RequestMapping(
			  value = "/kidsprofile/update", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String updateKidsDetails(@RequestBody String id) throws Exception {
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      //read JSON file and convert to a customer object
      ChildDetails customer = objectMapper.readValue(id, ChildDetails.class);

      //print customer details
      System.out.println(customer.toString());
	        return "Hello World RESTful with Spring Boot:-  " +id;
	    }
	
	@RequestMapping(
			  value = "/kidsprofile/delete", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String deleteKidsDetails(@RequestBody String id) throws Exception {
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      //read JSON file and convert to a customer object
      ChildDetails customer = objectMapper.readValue(id, ChildDetails.class);

      //print customer details
      System.out.println(customer.toString());
      customer.setId(Integer.parseInt(id));
      childRepository.delete(customer);
	        return "Hello World RESTful with Spring Boot:-  " +id;
	    }
	
	@RequestMapping(
			  value = "/kidsprofile/read", 
			  method = RequestMethod.GET)
	@ResponseBody
	    public String readKidsDetails() throws Exception {
		 //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      List <ChildDetails> list = childRepository.findAll();
      //print customer details
      for(int i=0;i<list.size();i++)
      {
    	  ChildDetails cd = list.get(i);
    	  System.out.println("Child name is :- "+cd.getName());
    	  System.out.println("Child Dotor name is :- "+cd.getDoctor_Name());
      }
	        return "Hello World RESTful with Spring Boot:-  ";
	    }

}
