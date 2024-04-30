package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
public class JsonPlaceholderGeo {

    private String lat;

    private String lng;

    private List < JsonPlaceholderAddress > address = new ArrayList<>();

}
