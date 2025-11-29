/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;

/**
 *
 * @author freecoin
 */
public class CmTouch extends Commande{
    private String nom;
    
    @Override
    public void executer() {
         Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nom);
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
    
}
