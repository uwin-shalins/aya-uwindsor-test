package com.uwindsor.unnovate.aya.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uwindsor.unnovate.aya.model.ChildDetails;

@RestController
public class LightController {
	
	@RequestMapping(
			  value = "/lightstatus/changeLightStatus", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	    public String changeLightStatus(@RequestBody String id) throws Exception {
		 //create ObjectMapper instance
	      ObjectMapper objectMapper = new ObjectMapper();
	
	      if(id.equals("0"))
		        return "Light Turned ON";
	      else
	    	  return "Light Turned OFF";
		}

}
