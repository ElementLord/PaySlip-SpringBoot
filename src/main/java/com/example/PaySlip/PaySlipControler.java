package com.example.PaySlip;

import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaySlipControler {
	
	@RequestMapping
	public List<Employee> PaySlip() 
	{
		return Arrays.asList(new Employee("Monica","Tan",60050,"9%","01 March – 31 March"));
	}
	
}
