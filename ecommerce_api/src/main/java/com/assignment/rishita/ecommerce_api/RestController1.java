package com.assignment.rishita.ecommerce_api;

// annotation imports
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

//java.util imports
import java.util.List;
import java.util.HashMap;

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
            int price = getFinalAmount(IDs);
            return price;
	}


	int getFinalAmount(List<String> IDs){
       
        //po (purchase order) hashmap will contain the watch IDs as key and quantity ordered as values.
        HashMap<String,Integer> po = new HashMap<String,Integer>(); 

        // loop through all IDs input and update the quantity in po hashmap
        for(int i=0; i<IDs.size(); i++){
            if(po.containsKey(IDs.get(i))==false){
                po.put(IDs.get(i),1);
            }
			else{
            	po.put(IDs.get(i),po.get(IDs.get(i))+1);
			}
        }

        //calculate final price- loop through all IDs in po hashmap and take necessary steps 
        int price = 0;

        for(String id: po.keySet()){

            //get Database table record values for that ID
           Watch a = WatchRepository.getById(id);
           int discountQuantity = a.getDiscountQuantity();
           int unitPrice = a.getUnitPrice();

            // get quantity to be purchased from po hashmap
           int quantityToBePurchased = po.get(id);

            // if discount applies on this WatchID, then increment total price accordingly
           if(discountQuantity!=0 && quantityToBePurchased>=discountQuantity){
                int discountVal = a.getDiscountVal();
                while(quantityToBePurchased>=discountQuantity){
                    price += discountVal;
                    quantityToBePurchased -= discountQuantity;
                }
           }

           
           price += (quantityToBePurchased * unitPrice);

        }
       
    
        return price;
    }   





}
