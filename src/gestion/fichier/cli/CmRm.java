/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.FichierSimple;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;


/**
 *
 * @author freecoin
 */
public class CmRm extends Commande{
    private String nom;
    private Repertoire rep ;
    private FichierSimple fi;
    @Override
    public void executer() {
        try {
            //repertoire à supprimer
            rep = Navigateur.getInstance().getRepertoireCourant().getRepertoire(nom);
            //suppression
            Navigateur.getInstance().getRepertoireCourant().supprimer(rep);
        } catch (Exception e) {
            if(!Navigateur.getInstance().getRepertoireCourant().existeRepertoire(nom) && !Navigateur.getInstance().getRepertoireCourant().existeFichier(nom)){
                System.out.println(e.getMessage());
            }
        } 
        
        try {
            //fichier simple à supprimer
            fi= Navigateur.getInstance().getRepertoireCourant().getFichierSimple(nom);
            //suppression
            Navigateur.getInstance().getRepertoireCourant().supprimer(fi);  
            
        } catch (Exception e) {
             if(!Navigateur.getInstance().getRepertoireCourant().existeFichier(nom) && !Navigateur.getInstance().getRepertoireCourant().existeRepertoire(nom)){
                   System.out.println(e.getMessage());
             }
                  }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
    
}
