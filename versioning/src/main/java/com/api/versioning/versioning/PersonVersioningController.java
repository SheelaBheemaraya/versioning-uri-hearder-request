package com.api.versioning.versioning;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.bind.annotation.GetMapping;  
@RestController  
public class PersonVersioningController {
	//URL VERSIONING
	@GetMapping("v1/person")  
	public PersonV1 personv1()  
	{  
	return new PersonV1("Tom Cruise");  
	}  
	
	//this method is for the second version that returns firstName and lastName separately  
	@GetMapping("v2/person")  
	public Person2 personv2()  
	{  
	return new Person2(new Name("Tom", "Cruise"));  
	}  
	
	
	//Versioning using Request Parameter
	@GetMapping(value="/person/param", params="version=1")   
	public PersonV1 personparamv1()  
	{  
	return new PersonV1("Tom Cruise");  
	}  
	
	//this method is for the second version that returns firstName and lastName separately  
	@GetMapping(value="/person/param", params="version=2") 
	public Person2 personparamv2()  
	{  
	return new Person2(new Name("Tom", "Cruise"));  
	}  
	
	
	
	
	//Versioning using Request Header
	@GetMapping(value="/person/header", headers="X-API-KEY=1")    
	public PersonV1 personheaderv1()  
	{  
	return new PersonV1("Tom Cruise");  
	}  
	
	//this method is for the second version that returns firstName and lastName separately  
	@GetMapping(value="/person/header", headers="X-API-KEY=2")  
	public Person2 personheaderv2()  
	{  
	return new Person2(new Name("Tom", "Cruise"));  
	}  

}
