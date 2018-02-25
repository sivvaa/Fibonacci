package com.academy.dd;

import org.junit.Assert;

import java.util.ArrayList;

/**
 * Super class of all Test classes.
 * The methods used by all the Test classes should be added here.
 */
public class BaseTest {

    /**
     * Method to test the correctness of Fibonacci numbers
     * @param fibonacciNumbers
     */
    public void verifyFibonacciSeries(ArrayList fibonacciNumbers){
        for(int count = 2; count < fibonacciNumbers.size(); count++) {
            Assert.assertTrue("FAIL", getIntValue(fibonacciNumbers.get(count-2)) + getIntValue(fibonacciNumbers.get(count-1)) == getIntValue(fibonacciNumbers.get(count)));
        }
    }

    private int getIntValue(Object object) {
        return Integer.valueOf((String)object);
    }

}
