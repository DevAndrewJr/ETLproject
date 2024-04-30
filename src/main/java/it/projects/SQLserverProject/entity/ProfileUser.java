package it.projects.SQLserverProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "userProfile")
public class ProfileUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="street")
    private String street;

    @Column(name="suite")
    private String suite;

    @Column(name="city")
    private String city;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name="phone")
    private String phone;

    @Column(name="website")
    private String website;

    @Column(name="lat")
    private String lat;

    @Column(name="lng")
    private String lng;

    @Column(name="companyName")
    private String companyName;

    @Column(name="companyCatchPhrase")
    private String companyCatchPhrase;

    @Column(name="companyBs")
    private String companyBs;
}
