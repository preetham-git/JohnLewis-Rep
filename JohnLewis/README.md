## Running the application locally

You can run a Spring Boot application using either "com.johnlewis.JohnlewisApplication" class from your IDE or "Spring Boot Maven plugin"

## Test the API.

Need to pass the category Id as a mandatory field and price label type as optional parameter

Sample URL with category ID as mandatory
http://localhost:8080/ProductsByCategory/600001506

Sample URL with category ID as mandatory & priceType as ShowWasNow
http://localhost:8080/ProductsByCategory/600001506?priceType=ShowWasNow

Sample URL with category ID as mandatory & priceType as ShowWasThenNow
http://localhost:8080/ProductsByCategory/600001506?priceType=ShowWasThenNow

Sample URL with category ID as mandatory & priceType as ShowPercDscount
http://localhost:8080/ProductsByCategory/600001506?priceType=ShowPercDscount

## Output of the API.
An array of products. Each element should contain:
productId <String>
title <String>
An array of colorSwatches. Each element should contain:
color<String>
rgbColor<String> which is an RGB  representation of the basicColor in a six digit hexadecimal format, e.g. “F0A1C2”.
skuid<String>
nowPrice<String> which is the price.now represented as a string, including the currency, e.g. “£1.75”. For values that are integer, if they are less £10 return a decimal price, otherwise show an integer price, e.g. “£2.00” or  “£10”. 
priceLabel<String>. An optional query parm called labelType can be set to any of:
1.	ShowWasNow - in which case return a string saying “Was £x.xx, now £y.yyy”. 
2.	ShowWasThenNow - in which case return a string saying “Was £x.xx, then £y.yy, now £z.zzz”. If the original price.then2 is not empty use that for the “then” price otherwise use the then1 price. If the then1 price is also empty then don’t show the “then” price.
3.	ShowPercDscount  - in which case return “x% off - now £y.yy”.
If the query parm is not set default to use ShowWasNow format.
In all cases use the price formatting as described for nowPrice.


## Explanation

* main
    * java
        * com.config
            * config		-> to add configurations
		* com.constants
			* enum classes  -> constant classes for currency , price label type & RGB colors
		* com.Johnlewis
            * controller    -> api process for client			
            * JohnlewisApplication.java -> You can start project with this class.
		* com.converter
            * converter     -> converter models to entities
		* com.exceptions
            * exception     -> handle exceptions
		* com.model
            * model         -> entities for api
		* com.service
            * repository    -> Business logic for api process
    * resources
        * application.properties -> project configuration

