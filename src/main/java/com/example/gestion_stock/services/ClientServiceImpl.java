package com.example.gestion_stock.services;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client AddClient(Client client) {
        return repository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @Override
    public Client findClientById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteClient(Long id) {
       repository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }
}
