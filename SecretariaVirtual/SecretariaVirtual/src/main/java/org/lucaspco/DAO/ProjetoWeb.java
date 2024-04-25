package org.lucaspco.DAO;
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
    @Bean
    public CommandLineRunner init(@Autowired UsuarioDAO usuarios) {
        return args -> {
            Usuario c = new Usuario();
            c.setNome("Lucas Paiva");
            usuarios.salvarUsuario(c);

            c = new Usuario("Juliane Itapoa.");
            usuarios.salvarUsuario(c);
            List <Usuario> listaCli = usuarios.obterTodos();
            listaCli.forEach(System.out::println);

            listaCli = usuarios.obterUsuarioByNome("Lucas");
            listaCli.forEach(System.out::println);

            System.out.println("Atualizando Usuarios");
            listaCli.forEach(cl -> {
                cl.setNome(cl.getNome() + " Atualizado");
                usuarios.atualizarCliente(cl);
            });
            System.out.println("Listando usuarios Atualizados");
            listaCli = usuarios.obterTodos();
            listaCli.forEach(System.out::println);;
            listaCli = usuarios.obterUsuarioByNome("Doug");
            System.out.println("Listando usuario especifico");
            listaCli.forEach(System.out::println);;
            System.out.println("Removendo 1 usuario");
            listaCli.forEach(cl -> {
                cl.setId(1);
                usuarios.deletarCliente(cl);
            });
            listaCli = usuarios.obterTodos();
            System.out.println("Listando usuarios pela ultima vez");
            listaCli.forEach(System.out::println);
        };
    };

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(ProjetoWeb.class, args);}
}
