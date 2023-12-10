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

import com.example.demo.Entity.Moto;
import com.example.demo.Repositorio.MotoRepositorio;

@RestController
@RequestMapping("/motos")
public class MotoController {

    public MotoRepositorio motoRepositorio;

    public MotoController(MotoRepositorio motoRepositorio) {
        this.motoRepositorio = motoRepositorio;
    }

    @GetMapping
    public List<Moto> getMotoAll() {
        return motoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Moto getMotoById(@PathVariable Integer id) {
        Optional<Moto> moto = motoRepositorio.findById(id);
        if (moto.isPresent()) {
            return moto.get();
        }
        return null;
    }

    @PostMapping
    public Moto postMoto(@RequestBody Moto moto) {
        motoRepositorio.save(moto);
        return moto;
    }

    @PutMapping("/{id}")
    public Moto putMotoById(@PathVariable Integer id, @RequestBody Moto moto) {
        Optional<Moto> motoBase = motoRepositorio.findById(id);
        if (motoBase.isPresent()) {
            Moto motoActualizado = motoBase.get();

            motoActualizado.setPlaca(moto.getPlaca());
            motoActualizado.setColor(moto.getColor());
            motoActualizado.setMarca(moto.getMarca());
            motoActualizado.setModelo(moto.getModelo());
            motoActualizado.setCilindraje(moto.getCilindraje());

            motoRepositorio.save(motoActualizado);

            return motoActualizado;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Moto deleteMotoById(@PathVariable Integer id) {
        Optional<Moto> moto = motoRepositorio.findById(id);
        if (moto.isPresent()) {
            Moto motoReturn = moto.get();
            motoRepositorio.deleteById(id);

            return motoReturn;
        }
        return null;
    }
}
