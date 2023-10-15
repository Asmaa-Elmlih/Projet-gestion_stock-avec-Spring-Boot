package com.example.gestion_stock.controllers;

import com.example.gestion_stock.models.Client;
import com.example.gestion_stock.models.Fournisseur;
import com.example.gestion_stock.models.Produit;
import com.example.gestion_stock.repositories.ProduitRepository;
import com.example.gestion_stock.services.FournisseurService;
import com.example.gestion_stock.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/fournisseur")
public class FournisseurController {
    private final ProduitRepository repository;
    private final ProduitService servicepr;

    @Autowired
    private FournisseurService service;

    public FournisseurController(ProduitRepository repository, ProduitService servicepr) {
        this.repository = repository;
        this.servicepr = servicepr;
    }
   /* @PostMapping("/addProduit")
    public String addProduitToFournisseur(@RequestParam("fournisseurId") Long fournisseurId,
                                          @RequestParam("produitId") Long produitId) {
        Fournisseur fournisseur = service.findFournisseurById(fournisseurId);
        Optional<Produit> produit = repository.findById(produitId);

        return "redirect:/fournisseur/list";
    }*/


    @GetMapping("/addFrr")
    public String addNewFournisseur(Model model) {
        List<Produit> produits = repository.findAll();
        model.addAttribute("produits", produits);
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setProduits(produits);
        model.addAttribute("fournisseur", fournisseur);
        return "AddFournisseur";
    }

   /* @PostMapping("/addFrr")
    public String createFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
        service.AddFournisseur(fournisseur);
        return "redirect:/api/fournisseur/list";
    }*/
   @PostMapping("/addFrr")
   public String createFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
       service.AddFournisseur(fournisseur);
       return "redirect:/api/fournisseur/list";
   }
    @GetMapping("/list")
    public String getAllFournisseur(Model model,Long id){
        List<Fournisseur> fournisseurs = service.getAllFournisseurs();

        // Pour chaque fournisseur, récupérer les produits associés
        for (Fournisseur fournisseur : fournisseurs) {
            List<Produit> produits = fournisseur.getProduits();
            fournisseur.setProduits(produits);
        }
        model.addAttribute("fournisseurs",fournisseurs);
        return "Fournisseurs";
    }

    @GetMapping("/updateFrr/{id}")
    public String showUpdateFormFournisseur(@PathVariable(value="id") Long id, Model model) {
        List<Produit> produits = repository.findAll();
        model.addAttribute("produits", produits);
        Fournisseur fournisseur= service.findFournisseurById(id);
        model.addAttribute("fournisseur", fournisseur);
        return "updateFournisseur";
    }

    @PostMapping ("/updateFrr/{id}")
    public String updateFournisseur(@PathVariable("id") Long id, @ModelAttribute("fournisseur") Fournisseur fournisseur) {
        fournisseur.setId(id);
        service.updateFournisseur(fournisseur);
        return "redirect:/api/fournisseur/list";
    }
  /*  @DeleteMapping("/deleteFrr/{id}")
    public String deleteFournisseur(@PathVariable(value="id") Long id){
        service.deleteFournisseur(id);
        return "redirect:/api/fournisseur/list";
    }*/
  @GetMapping("/delete/{id}")
  public String showDeleteConfirmationPage(@PathVariable("id") Long id, Model model) {
      Fournisseur fournisseur = service.findFournisseurById(id);
      model.addAttribute("fournisseur", fournisseur);
      return "deleteFournisseur";
  }

    @DeleteMapping("/delete/{id}")
    public String deleteFournisseurs(@PathVariable("id") Long id) {
        service.deleteFournisseur(id);
        return "redirect:/api/fournisseur/list";
    }



}
