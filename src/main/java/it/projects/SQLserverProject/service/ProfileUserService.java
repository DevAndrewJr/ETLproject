package it.projects.SQLserverProject.service;

import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.repository.*;
import it.projects.SQLserverProject.entity.*;
import it.projects.SQLserverProject.config.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Service
public class ProfileUserService {

    @Autowired
    private ProfileUserRepository profileUserRepository;

    FetchJsonPlaceholderUserService fetchJsonPlaceholderUserService = new FetchJsonPlaceholderUserService();


    public void saveUsersToProfile() {
        try {
            // Ottieni la lista delle persone dalla chiamata API
            List< Map< String, Object > > peopleList = fetchJsonPlaceholderUserService.getListPeople();

            // Itera attraverso ogni mappa di persona
            for (Map< String, Object > userMap : peopleList) {
                ProfileUser profileUser = new ProfileUser();

                // Imposta i campi del profilo utente dai dati della mappa
                profileUser.setUsername((String) userMap.get("username"));
                profileUser.setEmail((String) userMap.get("email"));
                profileUser.setStreet((String) userMap.get("street"));
                profileUser.setSuite((String) userMap.get("suite"));
                profileUser.setCity((String) userMap.get("city"));
                profileUser.setZipcode((String) userMap.get("zipcode"));
                profileUser.setPhone((String) userMap.get("phone"));
                profileUser.setWebsite((String) userMap.get("website"));
                profileUser.setLat((String) userMap.get("lat"));
                profileUser.setLng((String) userMap.get("lng"));
                profileUser.setCompanyName((String) userMap.get("companyName"));
                profileUser.setCompanyCatchPhrase((String) userMap.get("companyCatchPhrase"));
                profileUser.setCompanyBs((String) userMap.get("companyBs"));

                // Salva il profilo utente nel database
                profileUserRepository.save(profileUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
