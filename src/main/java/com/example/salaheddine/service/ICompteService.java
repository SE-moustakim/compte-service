package com.example.salaheddine.service;

import enset.glsid.billingservice.models.Compte;
import enset.glsid.billingservice.models.Operation;
import org.springframework.data.domain.Page;

public interface ICompteService {
    public Compte ajouterCompte(Compte compte);
    public Compte consulterCompte(Long code);
    public void retrait(Long codeCompte, double montant);
    public void verser(Long codeCompte, double montant);
    public void verment(Long codeCompte1,Long codeCompte2, double montant);
    public Page<Operation> listOperations(Long codeCompte, int page, int size);
    public void activer(Long codeComte);
    public void suspendre(Long codeCompte);
}
