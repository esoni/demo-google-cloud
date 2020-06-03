package it.italiancoders.demo;

import it.italiancoders.demo.entity.HelloEntity;
import it.italiancoders.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    @Value("${hello.message}")
    String message;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(HelloRepository helloRepository) {
        return args -> {
            HelloEntity helloEntity = new HelloEntity();
            helloEntity.setText(message);
            helloRepository.save(helloEntity);
        };
    }
}
