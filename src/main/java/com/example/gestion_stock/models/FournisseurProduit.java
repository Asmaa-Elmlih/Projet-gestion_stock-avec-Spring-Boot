package com.example.gestion_stock.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fournisseur_produit")
public class FournisseurProduit {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // Constructeurs, getters et setters
}
