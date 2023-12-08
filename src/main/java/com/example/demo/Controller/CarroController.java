package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Carro;
import com.example.demo.Repositorio.CarroRepositorio;


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

    @GetMapping("/{id}")
    public Carro getCarroById(@PathVariable Integer id){
        Optional<Carro> carro = carroRepositorio.findById(id);
        if (carro.isPresent()) {
            return carro.get();
        }
        return null;
    }

    @PostMapping
    public Carro postCarros(@RequestBody Carro carro){
        carroRepositorio.save(carro);
        return carro;
    }

    //Prueba del commit

}
