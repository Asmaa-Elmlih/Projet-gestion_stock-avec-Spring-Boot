package com.example.gestion_stock.repositories;

import com.example.gestion_stock.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

 /*   Produit save(Produit produit);
    List<Produit> findAll();
     Produit getById(Long id);*/

}
