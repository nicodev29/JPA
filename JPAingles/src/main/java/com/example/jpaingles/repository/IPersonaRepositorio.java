package com.example.jpaingles.repository;
import com.example.jpaingles.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona, Long> {

}

