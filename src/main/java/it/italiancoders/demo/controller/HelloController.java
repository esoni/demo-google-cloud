package it.italiancoders.demo.controller;

import it.italiancoders.demo.entity.HelloEntity;
import it.italiancoders.demo.repository.HelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Value("${hello.message}")
    String message;

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/hello")
    ResponseEntity<String> helloWorld() {
        HelloEntity helloEntity = helloRepository.findByText(message);
        log.info("Manage Hello World Request");
        return ResponseEntity.ok(helloEntity.getText());
    }
}
