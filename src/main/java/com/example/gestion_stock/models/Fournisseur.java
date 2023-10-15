package com.example.gestion_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFournisseur;
    private String nomSociete;
    private String typeProduit;
    @ManyToMany(fetch = FetchType.EAGER) // Charger les produits en utilisant FetchType.EAGER
    @JoinTable(name = "fournisseur_produit",
            joinColumns = @JoinColumn(name = "fournisseur_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private List<Produit> produits;
   /* public List<Produit> getProduits() {
        return produits;
    }*/



}
