package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.*;

@Data
public class JsonPlaceholderAddress {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private JsonPlaceholderGeo geo;

    private List<JsonPlaceholderUser> user = new ArrayList<>();


}
