package com.example.gestion_stock.controllers;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.models.Produit;
import com.example.gestion_stock.repositories.ProduitRepository;
import com.example.gestion_stock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/client")
public class ClientController {
    private final ProduitRepository repository;
    @Autowired
    private ClientService service;

    public ClientController(ProduitRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/addnew")
    public String addNewClient(Model model) {
        List<Produit> produits = repository.findAll();
        model.addAttribute("produits", produits);
        Client client = new Client();
        model.addAttribute("client", client);
        return "AddClient";
    }

    @PostMapping("/addnew")
    public String createClient(@ModelAttribute("client") Client client) {
        service.AddClient(client);
        return "redirect:/api/client/list";
    }

    @GetMapping("/list")
    public String getAllClient(Model model){
        model.addAttribute("clients",service.getAllClients());
        return "clients";
    }



    @GetMapping("/update/{id}")
    public String showUpdateFormClient(@PathVariable(value="id") Long id, Model model) {
        List<Produit> produits = repository.findAll();
        model.addAttribute("produits", produits);
        Client client= service.findClientById(id);
        model.addAttribute("client", client);
        return "updateClient";
    }

    @PostMapping ("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, @ModelAttribute("client") Client client) {
        client.setId(id);
        service.updateClient(client);
        return "redirect:/api/client/list";
    }

   /* @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable(value="id") Long id){
        service.deleteClient(id);
        return "redirect:/api/client/list";
    }*/

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmationPage(@PathVariable("id") Long id, Model model) {
        Client client = service.findClientById(id);
        model.addAttribute("client", client);
        return "deleteClient";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        service.deleteClient(id);
        return "redirect:/api/client/list";
    }






}
