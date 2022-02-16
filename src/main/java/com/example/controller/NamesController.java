package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.NamesService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/names")
@RestController	
public class NamesController {
	
	@Autowired
	NamesService namesService;
	
	@RequestMapping(value ="/getNamesSuggestions")
	@ApiOperation(value = "Get names suggestions for prefix")
	public List<String> getNamesSuggestions(@RequestParam String prefix) {
		return namesService.getNamesSuggestions(prefix);
	}

	

}
