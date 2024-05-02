package it.projects.SQLserverProject.service;

import it.projects.SQLserverProject.dto.*;
import it.projects.SQLserverProject.repository.*;
import it.projects.SQLserverProject.entity.*;
import it.projects.SQLserverProject.config.*;

import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Service
public class ProfileUserService {

    @Autowired
    private ProfileUserRepository profileUserRepository;

    @Autowired
    FetchJsonPlaceholderUserService fetchJsonPlaceholderUserService;

    @Deprecated 
    @DeclareAnnotation("This code isn't optimized")
    /**
     @Note: Implementare il mapping direttamente tra dto a entity
     */
    public void saveUsersToProfile() {
        try {

            // Get a people list of the API call
            List< Map< String, Object > > peopleList = fetchJsonPlaceholderUserService.getListPeople();

            // Itera attraverso ogni mappa di persona
            for (Map< String, Object > userMap : peopleList) {
                ProfileUser profileUser = new ProfileUser();

                // Imposta i campi del profilo utente dai dati della mappa
                profileUser.setName((String) userMap.get("name"));
                profileUser.setUsername((String) userMap.get("username"));
                profileUser.setEmail((String) userMap.get("email"));

                Map< String, Object > addressMap = (Map< String, Object >) userMap.get("address");
                if (addressMap != null) {
                    profileUser.setStreet((String) addressMap.get("street"));
                    profileUser.setSuite((String) addressMap.get("suite"));
                    profileUser.setCity((String) addressMap.get("city"));
                    profileUser.setZipcode((String) addressMap.get("zipcode"));
                }

                profileUser.setPhone((String) userMap.get("phone"));
                profileUser.setWebsite((String) userMap.get("website"));


                Map< String, Object > geoMap = (Map< String, Object >) userMap.get("geo");
                if (geoMap != null) {
                    profileUser.setLat((String) geoMap.get("lat"));
                    profileUser.setLng((String) geoMap.get("lng"));
                }


                Map< String, Object > companyMap = (Map< String, Object >) userMap.get("company");
                if (companyMap != null) {
                    profileUser.setCompanyName((String) companyMap.get("name"));
                    profileUser.setCompanyCatchPhrase((String) companyMap.get("catchPhrase"));
                    profileUser.setCompanyBs((String) companyMap.get("bs"));
                }

                // Salva il profilo utente nel database
                profileUserRepository.saveAndFlush(profileUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
