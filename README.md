# Fibonacci
Fibonacci API Tests

<b>The Tests are wtitten using RESTEasy, Java, Junit and Maven</b>
* com.academy.dd.FibonacciTest.java - Contain all the Tests
* com.academy.dd.apiCall.ApiCall.java - Contains the methods to call APIs

## Prerequisites
* Java 8 installed and configured the JAVA_HOME environment variable
* Maven installed and configured
* IntelliJ IDE for a code walk through (optional)

* The Fibonacci Serivemust be running.
To run the Fibonacci service, checkout the code from https://github.com/digital-delivery-academy/fibonacci-rest and run <br> `mvn clean  install` <br>and then <br> `mvn exec:java -Dexec.mainClass="academy.dd.fibonacci.App"` <br>
This will now start the Fibonacci Service

## To run the API tests 
* Clone the repoitory https://github.com/sivvaa/Fibonacci and run the following command <br>`mvn clean test -Durl=http://localhost:7003/fib` <br>
  If the Service is running on another machine, please change the url accordingly.
* There are only three positive tests written.

* If the `finishIndex` in the Query param is less than or equal to `startIndex`, the service does not return any numbers.

## What can be done if some more time is allowed 
* Adding additional Poitive and Negative tests.
* Adding Test Suites.
* Adding Exceptional handling.
* Adding Log.
* Reporting.
* Programming to interface rather than a Class directly 
  


