package com.example.gestion_stock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_produit;
    private String category;
    private int quantite;
    private double prix;
    @ManyToMany(mappedBy = "produits")
    private List<Client> clients;
    @ManyToMany(mappedBy = "produits")
    private List<Fournisseur> fournisseurs;

}
