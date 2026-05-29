package com.igorpolvora.workshopmongo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.igorpolvora.workshopmongo.domain.User;
import com.igorpolvora.workshopmongo.repository.UserRepository;
import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import com.igorpolvora.workshopmongo.domain.Post;
import com.igorpolvora.workshopmongo.repository.PostRepository;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import com.igorpolvora.workshopmongo.dto.AuthorDTO;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2026"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/01/2026"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}