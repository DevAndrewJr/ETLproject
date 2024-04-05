package it.projects.SQLserverProject.controller;

import it.projects.SQLserverProject.service.*;
import it.projects.SQLserverProject.dto.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping("/project/api/json")
public class JsonPlaceholderUserController {

    @Autowired
    private FetchJsonPlaceholderUserService fetchJsonPlaceholderUserService;

    @GetMapping(value = "user/list", produces="application/json")
    @ResponseBody
    public ResponseEntity<JsonPlaceholderUser> getList() throws JsonProcessingException{

        JsonPlaceholderUser jsonList = (JsonPlaceholderUser) fetchJsonPlaceholderUserService.fetchListUsers();

        return ResponseEntity.accepted().body(jsonList);
    }

    @GetMapping(value="user/get:{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<JsonPlaceholderUser> getUserById(@PathVariable("id") int id) throws  JsonProcessingException {

        JsonPlaceholderUser jsonUser = (JsonPlaceholderUser) fetchJsonPlaceholderUserService.fetchUserById(id);
        return null;
    }




}
