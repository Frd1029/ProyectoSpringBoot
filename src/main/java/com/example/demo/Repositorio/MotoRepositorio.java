package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Moto;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Integer> {
    
}
