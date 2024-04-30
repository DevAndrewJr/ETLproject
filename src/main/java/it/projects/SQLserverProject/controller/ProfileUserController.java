package it.projects.SQLserverProject.controller;

import it.projects.SQLserverProject.service.*;
import it.projects.SQLserverProject.config.*;
import it.projects.SQLserverProject.dto.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/project/api/json")
public class ProfileUserController {

    @Autowired
    private ProfileUserService profileUserService;

    @Autowired
    public ProfileUserController(ProfileUserService profileUserService) {
        this.profileUserService = profileUserService;
    }

    @PostMapping(value = "/users/save", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> saveJsonUser() {
        profileUserService.saveUsersToProfile();
        return ResponseEntity.ok("Users saved to profile successfully");
    }
}
