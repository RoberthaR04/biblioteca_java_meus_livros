package com.biblioteca.meuslivros;

import com.biblioteca.meuslivros.model.Livro;
import com.biblioteca.meuslivros.repository.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MeuslivrosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeuslivrosApplication.java, args);
    }

    // Este Bean será executado na inicialização e insere dados no H2
    @Bean
    CommandLineRunner initDatabase(LivroRepository repository) {
        return args -> {
            repository.saveAll(Arrays.asList(
                    new Livro("Alice no País das Maravilhas", "Lewis Carroll", "Fantasia", "Um clássico sobre uma menina que cai na toca do coelho.", "https://m.media-amazon.com/images/I/71DA9AeL8sL._AC_UF1000,1000_QL80_.jpg"),
                    new Livro("As Crônicas de Nárnia", "C.S. Lewis", "Fantasia", "Aventuras em um mundo mágico acessado por um guarda-roupa.", "https://m.media-amazon.com/images/I/71yJLhLftBL._AC_UF1000,1000_QL80_.jpg"),
                    new Livro("O Hobbit", "J.R.R. Tolkien", "Fantasia", "A jornada inesperada de Bilbo Bolseiro.", "https://m.media-amazon.com/images/I/91M-tV3BXZL._AC_UF1000,1000_QL80_.jpg"),
                    new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Fábula", "Um piloto encontra um jovem príncipe que caiu na Terra.", "https://m.media-amazon.com/images/I/71UWoH-EEAL._AC_UF1000,1000_QL80_.jpg")
            ));
        };
    }
}
