package com.assignment.rishita.ecommerce_api;

// annotation imports
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

//java.util imports
import java.util.List;

//other imports
import org.springframework.http.MediaType;



@RestController
public class RestController1 {

    @Autowired
	WatchRepository WatchRepository;


    
	@GetMapping(value = "/display")
	public List<Watch> display(){
		return WatchRepository.findAll();
	}
	@PostMapping(value = "/checkout",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public int checkout(@RequestBody List<String> IDs){
		//TODO: call method which will calculate total price and return
        return 0;
	}





}
