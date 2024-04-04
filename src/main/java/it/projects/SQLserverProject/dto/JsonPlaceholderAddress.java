package it.projects.SQLserverProject.dto;

import lombok.*;

@Data
public class JsonPlaceholderAddress {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private JsonPlaceholderGeo geo;

}
