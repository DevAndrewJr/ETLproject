package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Table(name="geo")
public class JsonPlaceholderGeo {

    @Id
    @Column(name = "id_geo")
    private int geo;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @JsonIgnore
    @OneToMany
            (
                    cascade = CascadeType.REFRESH,
                    fetch = FetchType.EAGER,
                    mappedBy = "geo",
                    orphanRemoval = true
            )
    private List < JsonPlaceholderAddress > address = new ArrayList<>();

}
