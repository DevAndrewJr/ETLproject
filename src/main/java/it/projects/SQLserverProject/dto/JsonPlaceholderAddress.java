package it.projects.SQLserverProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.*;

@Data
@Entity
@Table(name="address")
public class JsonPlaceholderAddress {

    @Id
    @Column(name="id_address")
    private Integer id;

    @Column(name="street")
    private String street;

    @Column(name="suite")
    private String suite;

    @Column(name="city")
    private String city;

    @Column(name="zipcode")
    private String zipcode;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_geo", referencedColumnName = "id_geo")
    private JsonPlaceholderGeo geo;


    @JsonIgnore
    @OneToMany
            (
                    cascade = CascadeType.REFRESH,
                    fetch = FetchType.EAGER,
                    mappedBy = "address",
                    orphanRemoval = true
            )
    private List<JsonPlaceholderUser> user = new ArrayList<>();


}
