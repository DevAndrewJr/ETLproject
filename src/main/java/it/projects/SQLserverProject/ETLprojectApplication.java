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


    }
}

