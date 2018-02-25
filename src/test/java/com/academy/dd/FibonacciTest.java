package com.academy.dd;

import com.academy.dd.apiCalls.ApiCalls;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test class for all the API calls
 */
public class FibonacciTest extends BaseTest {

    private static ApiCalls apiCalls;

    //The following members should be parameterised.
    private static String url;
    private static final String[] fibnocciNumbers = new String[] {"0", "1", "1", "2", "3", "5", "8", "13", "21", "34"};
    private static final int startIndex = 1;
    private static final int finishIndex = 10;
    private static final int selectedIndex = 5;

    @BeforeClass
    public static void setUp() {
        apiCalls = new ApiCalls();
        url = System.getProperty("url", "http://localhost:7003/fib");
    }

    /**
     * Testing API /fib
     */
    @Test
    public void fibPathTest() {
        ArrayList<String> actual = apiCalls.customGetCall(url);
        ArrayList<String> expected = new ArrayList<String>( Arrays.asList( fibnocciNumbers ));
        Assert.assertTrue(
                        "The fibonacci numbers returned by the API are incorrect",
                        actual.equals(expected)
        );
    }

    /**
     * Testing API with range
     * /fib/range?startIndex=&finishIndex=
     */
    @Test
    public void queryParamTest() {
        ArrayList<String> actualFibonacciNumbers = apiCalls.customGetCallWithQueryParams(url+"/range", startIndex, finishIndex);
        Assert.assertTrue(
                        "The fibonacci numbers returned by the API are incorrect",
                actualFibonacciNumbers.size() == (finishIndex - startIndex)
                        );
        verifyFibonacciSeries(actualFibonacciNumbers);
    }

    /**
     * Testing API with path parameter
     * /fib/{index}
     */
    @Test
    public void pathParamTest() {
        String actual = apiCalls.customGetCallWithPathParam(url, selectedIndex);
        ArrayList<String> fibonacciNumbers = apiCalls.customGetCallWithQueryParams(url+"/range", 0, selectedIndex);
        //Check the value returned by the path param call should be equal to sum of last two numbers of the fibomacci numbers
        Assert.assertTrue(
                "The fibonacci numbers returned by the API are incorrect",
                Integer.parseInt(actual) == (Integer.parseInt(fibonacciNumbers.get(selectedIndex-1)) + Integer.parseInt(fibonacciNumbers.get(selectedIndex-2)))
                );

    }

    @AfterClass
    public static void tearDown() {
        //Any tear down tasks - Nothing to do for now.
    }
}
