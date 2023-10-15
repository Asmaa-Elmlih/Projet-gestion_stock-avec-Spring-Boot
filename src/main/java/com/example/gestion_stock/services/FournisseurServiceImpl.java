package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Fournisseur;
import com.example.gestion_stock.repositories.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurServiceImpl implements FournisseurService{
    private final FournisseurRepository repository;

    public FournisseurServiceImpl(FournisseurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Fournisseur AddFournisseur(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return repository.findAll();
    }

    @Override
    public Fournisseur findFournisseurById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteFournisseur(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }
}
