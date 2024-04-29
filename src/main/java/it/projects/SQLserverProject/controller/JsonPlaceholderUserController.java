package it.projects.SQLserverProject.controller;

import it.projects.SQLserverProject.service.*;
import it.projects.SQLserverProject.dto.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.*;
import java.util.*;

@RestController
@RequestMapping("/project/api/json")
public class JsonPlaceholderUserController {

    @Autowired
    private FetchJsonPlaceholderUserService fetchJsonPlaceholderUserService;

    @GetMapping(value = "/user/list", produces="application/json")
    @ResponseBody
    public ResponseEntity< ? > getList() throws JsonProcessingException{

        List< JsonPlaceholderUser > jsonList = fetchJsonPlaceholderUserService.fetchUserList();

        return ResponseEntity.accepted().body(jsonList);
    }


    @GetMapping(value="user/get/{id}", produces = "application/json")
    @ResponseBody
    public JsonPlaceholderUser getUserById(@PathVariable("id") int id) throws  JsonProcessingException {

        JsonPlaceholderUser jsonUser = fetchJsonPlaceholderUserService.fetchUserById(id);
        return jsonUser;
    }

    @GetMapping(value="user/search/{name}", produces = "application/json")
    @ResponseBody
    public ResponseEntity< ? > searchName(@PathVariable("searchText") String searchText) throws JsonProcessingException{

        List<JsonPlaceholderUser> jsonSearch = fetchJsonPlaceholderUserService.findAllByNameContainingIgnoreCase(searchText);
        return ResponseEntity.accepted().body(jsonSearch);
    }
}
