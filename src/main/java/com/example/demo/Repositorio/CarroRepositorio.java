package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Carro;

@Repository
public interface CarroRepositorio extends JpaRepository<Carro, Integer> {
    
}
