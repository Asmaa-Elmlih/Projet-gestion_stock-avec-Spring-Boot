package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.models.Fournisseur;

import java.util.List;

public interface ClientService {
    Client AddClient(Client client);

    List<Client> getAllClients();

    Client findClientById(Long id);
    void deleteClient(Long id);

    Client updateClient(Client client);
}
