# Ecommerce-API for watch Catalogue
##### - By Rishita Arora, Final year BE Computer Science student at BITS Pilani Dubai Campus (2017A7PS0168U)

Github link:
https://github.com/RishitaArora/ADQ-Assignment

## Summary:
#### Purpose : 
This is a useful REST API for a specific watch catalogue which returns the total checkout price after applying discounts.

#### TechStack: 
SpringBoot, Java, MySQL

#### Request - Response for the REST API:
Input request in form of list of IDs of items, post processing output as a response post applying discounts. States the total price of the selected items.

## Program logic and details
#### Request input and response output:
The user needs to send a post request in the form of a request and recieves the output in the form of response as shown  below. The post request can be sent using postman/ your program or any other application which supports post queries. 

```sh
POST http://localhost:8080/checkout
#Headers
Accept:application/json
Content-Type: application/json
#Body:
[
"001",
"002",
"001",
"004",
"003"
]
```
```sh
#Headers
Content-Type: application/json
#Body:
[
"price": 360
]
```

#### Database table Watch:
The values in the Watch table are given below. The table gives the Watch ID, Watch Name, Unit price, Discount quantity and disocunt value for each Watch. The "discountQuantity" tells the quantity which can be sold for the "dicountVal" for each WatchID at the discounted rate.
```sh
[{"watchID":"001","watchName":"Rolex","unitPrice":100,"discountVal":200,"discountQuantity":3},
{"watchID":"002","watchName":"Michael Kors","unitPrice":80,"discountVal":120,"discountQuantity":2},
{"watchID":"003","watchName":"Swatch","unitPrice":50,"discountVal":0,"discountQuantity":0},
{"watchID":"004","watchName":"Casio","unitPrice":30,"discountVal":0,"discountQuantity":0}]
```

#### To use the program on your local machine:
> Step 1. Database "Catalogue" containing the "Watch" Table is in the "DB" folder and should be imported prior to the use of this app.
Step 2. Run the "ecommerce_api\src\main\java\com\assignment\rishita\ecommerce_api\EcommerceApiApplication.java"
Step 3. Send a post request on:
```sh
http://localhost:8080/checkout
```

> Step 4. Check the price in the response recieved.

#### Development:
This version control was done through github desktop. The development was done on Visual Studio Code, programming language used is Java and database used in MySQL. 
SpringBoot is used for creating this API with its devtools and JPA repository.
-  RestController1 controller class is the controller class with checkout route method.
- Method "getFinalAmount()" was implemented which returns the final checkout cost. The same is called from the checkout route method.
- Database "catalogue" with table named "Watch" is created in MySQL and corresponding Entity class named Watch created in Java.
- WatchRepository.java file is the repository created which extends from JPARepository
- Dependencies were added into pom.xml and database connectivity was done through applications.properties file.
- The testing was done on postman to ensure proper working of the code.
 
#### Testing
> Various Integration and Unit tests are written for the testing of the application. Integration/functional tests include basic context loads test, HttpRequestTest, SmokeTest and WatchRepositoryIntegrationTest.
Unit tests are written in JUnitTests.java for various cases :
1. Checkout with an empty cart should work
2. Simple checkout with no discounts should work with correct output
3. Checkout with one discount should work with correct output
4. Checkout with two discount should work with correct output
5. Checkout with two discounts on same item should work with correct output
6. Checkout with two discounts on same item and one non-discount item of same WatchID should work with correct output
7. Checkout containing IDs which are not mentioned in Watch table should ignore the irrelevant IDs while returning output.

#### Future Work
In the future, we can add more integration tests. We can also increase the scope from just watches to multiple items.


#### License

MIT
