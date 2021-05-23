package com.muito_rico.muito_rico.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import lombok.*;

@Entity(name = "cambio")
@Data
public class Cambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "moeda_origem")
    private String moedaOrigem;
    @Column(name = "moeda_destino")
    private String moedaDestino;
    @Column(name = "data_cambio")
    private Date dataCambio;
    @Column(name = "valor_original")
    private Float valorOriginal;
    @Column(name = "valor_convertido")
    private Float valorConvertido;
    private Float taxa;

}
