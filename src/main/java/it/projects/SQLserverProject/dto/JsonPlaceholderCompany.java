package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Table(name="company")
public class JsonPlaceholderCompany {

    @Id
    @Column(name="id_company")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="catchPhrase")
    private String catchPhrase;

    @Column(name="bs")
    private String bs;

    @JsonIgnore
    @OneToMany
    (
        cascade = CascadeType.REFRESH,
        fetch = FetchType.EAGER,
        mappedBy = "company",
        orphanRemoval = true
    )
    private List<JsonPlaceholderUser> user = new ArrayList<>();
    
}
