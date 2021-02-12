package com.example.salaheddine.service;

import enset.glsid.billingservice.dao.CompteRepository;
import enset.glsid.billingservice.dao.OperationRepository;
import enset.glsid.billingservice.models.Compte;
import enset.glsid.billingservice.models.Operation;
import enset.glsid.billingservice.models.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ImpCompteService implements ICompteService{


    @Autowired
    CompteRepository compteRepository;
    @Autowired
    OperationRepository operationRepository;

    @Override
    public Compte ajouterCompte(Compte compte) {
        return null;
    }

    @Override
    public Compte consulterCompte(Long code) {
        return compteRepository.findById(code).get();
    }

    @Override
    public void retrait(Long codeCompte, double montant) {
       Compte compte = consulterCompte(codeCompte);
        Versement versement = new Versement();
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde() - montant);
        compteRepository.save(compte);

    }

    @Override
    public void verser(Long codeCompte, double montant) {
        Compte compte = consulterCompte(codeCompte);
        Versement versement = new Versement();
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde() + montant);
        compteRepository.save(compte);
    }

    @Override
    public void verment(Long codeCompte1, Long codeCompte2, double montant) {
            retrait(codeCompte1, montant);
            verser(codeCompte2, montant);
    }

    @Override
    public Page<Operation> listOperations(Long codeCompte, int page, int size) {
        return operationRepository.findAllByCompte(codeCompte, PageRequest.of(page, size));
    }

    @Override
    public void activer(Long codeComte) {
        Compte compte = consulterCompte(codeComte);
        compte.setActive(true);
        compteRepository.save(compte);
    }

    @Override
    public void suspendre(Long codeCompte) {
        Compte compte = consulterCompte(codeCompte);
        compte.setActive(false);
        compteRepository.save(compte);
    }


}
