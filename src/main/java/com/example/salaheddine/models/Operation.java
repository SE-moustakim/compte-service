package com.example.salaheddine.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private double montant;
    private LocalDate dateOperation;
    @ManyToOne
    @JoinColumn
    private Compte compte;
}
