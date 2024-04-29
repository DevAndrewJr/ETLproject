package it.projects.SQLserverProject.service;

import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.exception.*;
import it.projects.SQLserverProject.config.*;

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

    public List< Map< String, Object > > getListPeople() {

        // Build an URL with user id
        String url = "https://jsonplaceholder.typicode.com/users/";

        try{
            ResponseEntity< JsonPlaceholderUser[] > response = restTemplate.getForEntity(url, JsonPlaceholderUser[].class);

            // Retrieve the array of users from the response
            Object[] objects = response.getBody();

            // Mapping
            ObjectMapper mapper = new ObjectMapper();

            // List for containing results
            List <Map <String, Object>> peopleList = new ArrayList<>();

            // Checking if the user list is void
            if (objects == null || objects.length == 0){
                throw new JsonPlaceholderUserListNotFoundException("Json placeholder users list not found");
            }

            // Iterating users
            for (Object obj : objects){

                // Converting the object to a JsonPlaceholderUser
                JsonPlaceholderUser user = mapper.convertValue(obj, JsonPlaceholderUser.class);

                // Mapping for rappresenting the current user
                Map<String, Object> userMap = new LinkedHashMap<>();

                // Adding the name of the user as key
                userMap.put(("id"), user.getId());
                userMap.put("name", user.getName());
                userMap.put("username", user.getUsername());
                userMap.put("email", user.getEmail());
                userMap.put("phone", user.getPhone());
                userMap.put("website", user.getWebsite());

                // Mapping for rappresenting the address user
                Map<String, Object> addressMap = new LinkedHashMap<>();
                JsonPlaceholderAddress address = user.getAddress();

                // Adding the user address as key
                addressMap.put(("street"), address.getStreet());
                addressMap.put(("suite"), address.getSuite());
                addressMap.put(("city"), address.getCity());
                addressMap.put(("zipcode"), address.getZipcode());

                // Mapping for rappresenting the geo of the street as key
                Map<String, Object> geoMap = new LinkedHashMap<>();
                JsonPlaceholderGeo geo = user.getAddress().getGeo();

                // Adding the street geo as key
                geoMap.put(("lat"), geo.getLat());
                geoMap.put(("lng"), geo.getLng());

                // Mapping for rappresenting the company of the user as key
                Map<String, Object> companyMap = new LinkedHashMap<>();
                JsonPlaceholderCompany company = user.getCompany();

                // Adding the company user as key
                companyMap.put(("name"), company.getName());
                companyMap.put(("catchPhrase"), company.getCatchPhrase());
                companyMap.put(("bs"), company.getBs());

                // Adding object maps nested in the user's map

                userMap.put("address", addressMap);
                userMap.put("geo", geoMap);
                userMap.put("company", companyMap);

                // Adding the user map to the results list
                peopleList.add(userMap);

            }
            return peopleList;

        }catch(HttpClientErrorException.NotFound e){
            throw new JsonPlaceholderUserNotFoundException("Failed to fetch users from JSONPlaceholder API", e);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }


}
