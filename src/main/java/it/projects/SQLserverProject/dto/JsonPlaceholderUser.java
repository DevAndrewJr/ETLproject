package it.projects.SQLserverProject.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
public class JsonPlaceholderUser {

    private int id;

    private String name;

    private String username;

    private String email;

    private JsonPlaceholderAddress address;

    private String phone;


    private String website;

    private JsonPlaceholderCompany company;


}
