package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Carro;
import com.example.demo.Repositorio.CarroRepositorio;

// Controlador para la entidad Carro
@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroRepositorio carroRepositorio;

    public CarroController(CarroRepositorio carroRepositorio) {
        this.carroRepositorio = carroRepositorio;
    }

    @GetMapping
    public List<Carro> getCarroAll() {
        return carroRepositorio.findAll();
    }

}
