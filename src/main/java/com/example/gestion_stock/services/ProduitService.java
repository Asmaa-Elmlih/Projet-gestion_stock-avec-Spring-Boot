package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Produit;
import com.example.gestion_stock.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IProduitService {

    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produit AddProduit(Produit produit){
        return repository.save(produit);
    }
    @Override
    public List<Produit> getAllProduit(){
        return repository.findAll();
    }
    @Override
    public Produit findProduitById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public void deleteProduit(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Produit updateProduit(Produit produit){
        return repository.save(produit);
    }




}
