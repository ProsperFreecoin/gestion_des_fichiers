/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author freecoin
 */
public class CmCD extends Commande{
    private String nom;
    
    @Override
    public void executer() {
        try {
            //Rester dans le meme rep si nom est null
            if(nom == null || nom.isEmpty()){
                Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
            }else{
                 Navigateur.getInstance().changerRepertoire(nom);
            }
           
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
            
    }

    @Override
    public void setParametres(String[] parametres) {
        //Si le parametre est null alors on retourne à la racine
        if(parametres == null || parametres.length ==0){
            return;
        }
        this.nom = parametres[0];
//        nveauRep = (Repertoire)Navigateur.getInstance().getRepertoireCourant();
    }
    
}
