package com.muito_rico.muito_rico.api;

import com.muito_rico.muito_rico.domain.Cambio;
import com.muito_rico.muito_rico.domain.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cambios")
public class CambioController {
    @Autowired
    private CambioService service;

    @GetMapping()
    public Iterable<Cambio> get(){
        return service.getCambio();
    }

    @GetMapping("/{id}")
    public Optional<Cambio> get(@PathVariable("id") Long id){

        return service.getCambioById(id);
    }
    @GetMapping("/total")
    public Float getTotal(){
        return service.getTotalCambios();
    }
    @GetMapping("/cliente/{nome}")
    public Iterable<Cambio> getCambioByNome(@PathVariable("nome") String nome){

        return service.getCambioByNome(nome);
    }
    @GetMapping("/data/{dataCambio}")
    public Iterable<Cambio> getCambioByDataCambio(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataCambio){

        return service.getCambioByDataCambio(dataCambio);
    }
    @PostMapping
    public String post(@RequestBody Cambio cambio){
        Cambio c = service.save(cambio);

        return "Cambio registrado!" + c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){

        service.delete(id);

        return "Cambio deletado com sucesso!";
    }
}
