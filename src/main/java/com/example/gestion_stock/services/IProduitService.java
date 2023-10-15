package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Produit;

import java.util.List;

public interface IProduitService {
    Produit AddProduit(Produit produit);

    List<Produit> getAllProduit();

    Produit findProduitById(Long id);
    void deleteProduit(Long id);

    Produit updateProduit(Produit produit);


}
