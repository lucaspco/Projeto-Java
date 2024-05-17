package org.lucaspco;
import org.lucaspco.DAO.UsuarioDAO;
import org.lucaspco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan
public class ProjetoWeb {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(ProjetoWeb.class, args);}
}
