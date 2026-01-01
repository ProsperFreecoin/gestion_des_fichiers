/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author freecoin
 */
public class CmLS extends Commande{
    private String nom;
    
    @Override
    public void executer() {
        try{
            //Affichage quand il y a pas de parametre
            if(nom == null){
                Navigateur.getInstance().getRepertoireCourant().afficherContenu();
            }else{
                //Affichage du contenu du rep precisé
                 Navigateur.getInstance().getRepertoireCourant().getRepertoire(nom).afficherContenu();
            }
           
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
      
    }

    @Override
    public void setParametres(String[] parametres) {
        if(parametres == null || parametres.length==0){
            return;
        }
        this.nom = parametres[0];
    }
    
}
