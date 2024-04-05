package it.projects.SQLserverProject.service;

import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.exception.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import com.fasterxml.jackson.databind.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchJsonPlaceholderUserService {




public List<JsonPlaceholderUser> fetchUserList(){

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
        if (objects == null || objects.length == 0) {
            throw new JsonPlaceholderUserListNotFoundException("Json placeholder users list not found");
        }

        List< JsonPlaceholderUser > jsonPlaceholderUserList = new ArrayList<>();

        for (int i = 0; i < objects.length; i++) {
            jsonPlaceholderUserList.add(mapper.convertValue(objects[i], JsonPlaceholderUser.class));
        }
        return jsonPlaceholderUserList;

    }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }



    public JsonPlaceholderUser fetchUserById(int id) {

        // Build an URL with user id
        String url = "https://jsonplaceholder.typicode.com/users/" + id;

        // Create the object RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity< JsonPlaceholderUser > response = restTemplate.getForEntity(url, JsonPlaceholderUser.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new JsonPlaceholderUserNotFoundException("Json placeholder user with id " + id + " not found");
            }
        }catch(HttpClientErrorException.NotFound e) {
            throw new JsonPlaceholderUserNotFoundException("Json placeholder user with id " + id + " not found", e);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

    }








}
