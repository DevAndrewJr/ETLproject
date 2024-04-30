package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
public class JsonPlaceholderCompany {

    private String name;

    private String catchPhrase;

    private String bs;

    private List<JsonPlaceholderUser> user = new ArrayList<>();
    
}
