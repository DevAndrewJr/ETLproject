package it.projects.SQLserverProject.service;

import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.exception.*;
import it.projects.SQLserverProject.config.*;

import it.projects.SQLserverProject.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import com.fasterxml.jackson.databind.*;

import java.util.*;


@Service
public class FetchJsonPlaceholderUserService {

    @Autowired
    private RestTemplate restTemplate;

    public List< JsonPlaceholderUser > fetchUserList() {

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

        } catch (Exception e) {
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
        } catch (HttpClientErrorException.NotFound e) {
            throw new JsonPlaceholderUserNotFoundException("Json placeholder user with id " + id + " not found", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public List< JsonPlaceholderUser > findUserByName(String name) {

        // Build an URL with user id
        String url = "https://jsonplaceholder.typicode.com/users/";

        // Create the object RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity< JsonPlaceholderUser[] > response = restTemplate.getForEntity(url, JsonPlaceholderUser[].class);

            if (response.getStatusCode().is2xxSuccessful()) {
                // Retrieve the array of users from response
                JsonPlaceholderUser[] users = response.getBody();

                // Convert the search name to lowercase
                String searchName = name.toLowerCase();

                // Filter users by name
                List< JsonPlaceholderUser > matchedUsers = new ArrayList<>();
                for (JsonPlaceholderUser user : users) {

                    // Convert the user name to lowercase for case-insensitive comparison
                    String userNameLowerCase = user.getName().toLowerCase();

                    if (userNameLowerCase.contains(searchName)) {
                        matchedUsers.add(user);
                    }
                }
                return matchedUsers;
            } else {
                throw new JsonPlaceholderUserNotFoundException("Failed to fetch users from JSONPlaceholder API");
            }


        } catch (HttpClientErrorException.NotFound e) {
            throw new JsonPlaceholderUserNotFoundException("Failed to fetch users from JSONPlaceholder API\", e");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
