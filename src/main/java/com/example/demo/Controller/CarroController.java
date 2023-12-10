package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Carro;
import com.example.demo.Repositorio.CarroRepositorio;


@RestController
@RequestMapping("/carros")
public class CarroController {
    private CarroRepositorio carroRepositorio;

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

    @PutMapping("/{id}")
    public Carro putCarroById(@PathVariable Integer id, @RequestBody Carro carro){
        Optional<Carro> carroBase = carroRepositorio.findById(id); 
        if (carroBase.isPresent()) {
            Carro carroActualizado = carroBase.get();

            carroActualizado.setPlaca(carro.getPlaca());
            carroActualizado.setColor(carro.getColor());
            carroActualizado.setMarca(carro.getMarca());
            carroActualizado.setModelo(carro.getModelo());
            carroActualizado.setCilindraje(carro.getCilindraje());
			
            carroRepositorio.save(carroActualizado);
			
			return carroActualizado;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Carro deleteCarroById(@PathVariable Integer id){
        Optional<Carro> carro = carroRepositorio.findById(id);
        if (carro.isPresent()) {
            Carro carroReturn = carro.get();
            carroRepositorio.deleteById(id);
            
            return carroReturn;
        }
        return null;
    }

}
