package it.projects.SQLserverProject.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="jsonPlaceholderUser")
public class JsonPlaceholderUser {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_address", referencedColumnName = "id_address")
    private JsonPlaceholderAddress address;

    @Column(name="phone")
    private String phone;

    @Column(name="website")
    private String website;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_company", referencedColumnName = "id_company")
    private JsonPlaceholderCompany company;


}
