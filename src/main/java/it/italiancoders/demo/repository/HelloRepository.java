package it.italiancoders.demo.repository;


import it.italiancoders.demo.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloEntity, Long> {
    HelloEntity findByText(String text);
}
