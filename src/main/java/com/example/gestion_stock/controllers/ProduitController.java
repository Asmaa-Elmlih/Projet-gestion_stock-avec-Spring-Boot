package com.example.gestion_stock.controllers;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.models.Produit;
import com.example.gestion_stock.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
    private ProduitService service;

   /* @GetMapping("/")
    public String produits(Model model) {
        model.addAttribute("listProducts",service.getAllProduit());
        return "produits";
    }*/

  /*  @PostMapping()
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit){
        return ResponseEntity.ok(service.AddProduit(produit));
    }*/


    @GetMapping("/addnew")
    public String addNewProduit(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        return "AddProduit";
    }

    @PostMapping("/addnew")
    public String createProduit(@ModelAttribute("produit") Produit produit) {
        service.AddProduit(produit);
        return "redirect:/api/produit/list";
    }


   /* @GetMapping()
    public ResponseEntity<List<Produit>> getAllProduit(){
        return ResponseEntity.ok(service.getAllProduit());
    }*/

  @GetMapping("/list")
    public String getAllProduit(Model model){
        model.addAttribute("produits",service.getAllProduit());
        return "produits";
    }

  /* @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id){
       return ResponseEntity.ok(service.findProduitById(id));
    }*/

    /*@PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id,@RequestBody Produit produit){
        produit.setId(id);
        return ResponseEntity.ok(service.updateProduit(produit));
    }*/

    @GetMapping("/update/{id}")
    public String showUpdateFormProduit(@PathVariable(value="id") Long id,Model model) {
        Produit produit= service.findProduitById(id);
        model.addAttribute("produit", produit);
        return "updateProduit";
    }

    @PostMapping ("/update/{id}")
    public String updateProduit(@PathVariable("id") Long id, @ModelAttribute("produit") Produit produit) {
        produit.setId(id);
        service.updateProduit(produit);
        return "redirect:/api/produit/list";
    }


   /* @DeleteMapping("/delete")
    public ResponseEntity<Produit> deleteProduit(@PathVariable Long id){
        service.deleteProduit(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.ok(service.deleteProduit(id));

    }*/

   /* @DeleteMapping("/delete/{id}")
    public String deleteProduit(@PathVariable(value="id") Long id){
       service.deleteProduit(id);
        return "redirect:/api/produit/list";
    }*/

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmationPage(@PathVariable("id") Long id, Model model) {
        Produit produit = service.findProduitById(id);
        model.addAttribute("produit", produit);
        return "deleteProduit";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        service.deleteProduit(id);
        return "redirect:/api/produit/list";
    }



}
