package com.muito_rico.muito_rico.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CambioService {

    @Autowired
    private CambioRepository rep;

    public Iterable<Cambio> getCambio(){
        return rep.findAll();
    }

    public Optional<Cambio> getCambioById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Cambio> getCambioByNome(String nome) {
        return rep.findByNome(nome);
    }

    public Cambio save(Cambio cambio) {

        return rep.save(cambio);
    }

    public void delete(Long id) {
        Optional<Cambio> cambio = getCambioById(id);
        if(cambio.isPresent()) {
            rep.deleteById(id);
        }
    }

    public Iterable<Cambio> getCambioByDataCambio(Date dataCambio) {
        return rep.findByDataCambio(dataCambio);
    }

    public Float getTotalCambios() {
        return rep.selectTotals();
    }
}
