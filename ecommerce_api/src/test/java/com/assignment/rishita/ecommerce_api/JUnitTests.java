package com.assignment.rishita.ecommerce_api;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = RestController1.class)
public class JUnitTests {
    private RestController1 rc ;

        @BeforeEach                                         
        public void setUp() throws Exception {
            rc = new RestController1();        
        }
    
        
        @Test                                               
        @DisplayName("Checkout with no item in cart should work")   
        public void testCheckoutWithNoItemOnCart() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList());

            assertEquals(0, rc.getFinalAmount(idList),      
            "Checkout with no item in cart should work");          
        
        }

        @Test                                               
        @DisplayName("Simple checkout with no discounts should work")   
        public void testSimpleCheckout() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList("001", "003", "002","001"));

            assertEquals(330, rc.getFinalAmount(idList),      
            "Simple checkout with no discounts should work");          
        }
    
        
        @Test                                               
        @DisplayName("Checkout with one discount should work")   
        public void testCheckoutWithOneDiscount() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList("001", "003", "002","002"));

            assertEquals(270, rc.getFinalAmount(idList),      
            "Checkout with one discounts should work");          
        }
       

        @Test                                               
        @DisplayName("Checkout with two discount should work")   
        public void testCheckoutWithTwoDiscounts() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList("001", "003", "002","002","001","001"));

            assertEquals(370, rc.getFinalAmount(idList),      
            "Checkout with two discounts should work");          
        }

        @Test                                               
        @DisplayName("Checkout with two discounts on same item should work")   
        public void testCheckoutWithTwoDiscountsOnSameItem() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList("001", "003", "002","002","002","002"));

            assertEquals(390, rc.getFinalAmount(idList),      
            "Checkout with two discounts on same item should work");          
        }

        
        @Test                                               
        @DisplayName("Checkout with two discounts on same item and one non-discount item of same WatchID should work")   
        public void testCheckoutWithTwoDiscountsAndOneNonDiscountOnSameItem() {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList("001", "002", "002","002","002","002"));

            assertEquals(420, rc.getFinalAmount(idList),      
            "Checkout with two discounts on same item and one non-discount item of same WatchID should work");          
        
    }
    @Test                                               
    @DisplayName("Checkout containing IDs which are not mentioned in Watch table should ignore the irrelevant IDs")   
    public void testCheckoutWithIDNotPresentInDB() {
        ArrayList<String> idList = new ArrayList<>(Arrays.asList("abc", "002", "002","002","002","002"));

        assertEquals(420, rc.getFinalAmount(idList),      
        "Checkout containing IDs which are not mentioned in Watch table should ignore the irrelevant IDs");          
    
}
    
}

