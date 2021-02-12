package com.example.salaheddine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long code;
   private double solde;
   private LocalDate dateCreation;
   @OneToMany(mappedBy = "compte")
   private Collection<Operation> operations;
   private boolean active;
   private Long clienId;
   @Transient
   private Client client;
}
