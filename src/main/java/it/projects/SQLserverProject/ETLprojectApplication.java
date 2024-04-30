package it.projects.SQLserverProject;

import it.projects.SQLserverProject.service.*;
import it.projects.SQLserverProject.dto.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.domain.*;

import java.util.List;
import java.util.Map;


@SpringBootApplication
public class ETLprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETLprojectApplication.class, args);


		FetchJsonPlaceholderUserService fetchService = new FetchJsonPlaceholderUserService();

		// Ottieni la lista degli utenti
		List<JsonPlaceholderUser> userList = fetchService.fetchUserList();

		// Stampa tutti i dati degli utenti
		for (JsonPlaceholderUser user : userList) {
			System.out.println("User Details:");
			System.out.println("ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Username: " + user.getUsername());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Phone: " + user.getPhone());
			System.out.println("Website: " + user.getWebsite());

			// Stampa l'indirizzo dell'utente
			System.out.println("Address:");
			System.out.println("Street: " + user.getAddress().getStreet());
			System.out.println("Suite: " + user.getAddress().getSuite());
			System.out.println("City: " + user.getAddress().getCity());
			System.out.println("Zipcode: " + user.getAddress().getZipcode());

			// Stampa le coordinate geografiche
			System.out.println("Geo:");
			System.out.println("Lat: " + user.getAddress().getGeo().getLat());
			System.out.println("Lng: " + user.getAddress().getGeo().getLng());

			// Stampa i dettagli della compagnia
			System.out.println("Company:");
			System.out.println("Name: " + user.getCompany().getName());
			System.out.println("Catch Phrase: " + user.getCompany().getCatchPhrase());
			System.out.println("Bs: " + user.getCompany().getBs());

			System.out.println(); // Aggiungi una riga vuota per separare i dati degli utenti

		}



	}

}
