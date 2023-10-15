package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Fournisseur;
import com.example.gestion_stock.models.Produit;

import java.util.List;

public interface FournisseurService {
    Fournisseur AddFournisseur(Fournisseur fournisseur);

    List<Fournisseur> getAllFournisseurs();

    Fournisseur findFournisseurById(Long id);
    void deleteFournisseur(Long id);

    Fournisseur updateFournisseur(Fournisseur fournisseur);
}
