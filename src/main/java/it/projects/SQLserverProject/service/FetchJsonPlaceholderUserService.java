package it.projects.SQLserverProject.service;

import com.fasterxml.jackson.databind.*;
import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.exception.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FetchJsonPlaceholderUserService {

public List<JsonPlaceholderUser> fetchListUsers(){

    // build rest template object
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";


    // rest call
    ResponseEntity< Object[] > response = restTemplate.getForEntity(url, Object[].class);

    // Tempory Varables
    Object[] objects = response.getBody();

    // Mapping
    ObjectMapper mapper = new ObjectMapper();

    // Return data variables
    try {
        List< JsonPlaceholderUser > jsonPlaceholderUserList = new ArrayList<>();

        if (jsonPlaceholderUserList.isEmpty()){
            throw new JsonPlaceholderUserListNotFoundException("Json placeholder users list not found");
        }

        for (int i = 0; i < objects.length; i++) {
            jsonPlaceholderUserList.add(mapper.convertValue(objects[i], JsonPlaceholderUser.class));
        }
        return jsonPlaceholderUserList;

    }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    public JsonPlaceholderUser fetchUserById(int userId) {

        // Build an URL with user id
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;

        // Create the object RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        try {
            List< JsonPlaceholderUser > jsonPlaceholderUser = new ArrayList<>();

            // Run the REST call for getting the specified user from id
            ResponseEntity<JsonPlaceholderUser> response = restTemplate.getForEntity(url, JsonPlaceholderUser.class);

            if (jsonPlaceholderUser.isEmpty()){
                throw new JsonPlaceholderUserNotFoundException("Json placeholder users not found");
            }

            // Return the user from response
            return response.getBody();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }


    }





}
