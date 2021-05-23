package com.muito_rico.muito_rico.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface CambioRepository extends CrudRepository<Cambio, Long> {
    Iterable<Cambio> findByNome(String nome);

    Iterable<Cambio> findByDataCambio(Date dataCambio);

    @Query("SELECT SUM(m.taxa) FROM cambio m")
    Float selectTotals();
}
