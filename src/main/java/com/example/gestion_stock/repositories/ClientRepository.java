package com.example.gestion_stock.repositories;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.models.Fournisseur;
import com.example.gestion_stock.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
