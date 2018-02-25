package com.academy.dd.apiCalls;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.academy.dd.apiCalls.utils.BaseApiCalls;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import java.util.ArrayList;

/**
 * Java class to encapsulate API calls
 */
public class ApiCalls extends BaseApiCalls {

    /**
     * Method for simple GET call
     * @param url
     * @return ArrayList
     */
    public ArrayList<String> customGetCall(String url) {
        Response response = getApiClient().target(url).request().get();
        String jsonString = response.readEntity(String.class);
        response.close();
        return convertResponseToArrayList(jsonString);
    }

    /**
     * Method for GET call with query parameters
     * @param url
     * @param startIndex
     * @param finishIndex
     * @return ArrayList
     */
    public ArrayList<String> customGetCallWithQueryParams(String url, int startIndex, int finishIndex) {
        MultivaluedMap<String, Object> multiValueMap = new MultivaluedMapImpl<String, Object>();
        multiValueMap.add("startIndex", startIndex);
        multiValueMap.add("finishIndex", finishIndex);

        Response response = getApiClient().target(url).queryParams(multiValueMap).request().get();
        String jsonString = response.readEntity(String.class);
        response.close();
        return convertResponseToArrayList(jsonString);
    }

    /**
     * Method for GET call with path parameter
     * @param url
     * @param pathParamValue
     * @return String
     */
    public String customGetCallWithPathParam(String url, int pathParamValue) {

        Response response = getApiClient().target(url).path(String.valueOf(pathParamValue)).request().get();
        String jsonString = response.readEntity(String.class);
        response.close();
        return jsonString;
    }

}
