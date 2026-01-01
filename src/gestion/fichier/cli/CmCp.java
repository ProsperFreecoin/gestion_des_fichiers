/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 * 
 * @author USER
 */
public class CmCp extends Commande{
    private String source;
    private String destination ;
    private Repertoire rep ;
//    private Repertoire repP ;
    @Override
    public void executer() {
        try {
            source = Navigateur.getInstance().getRepertoireCourant().getNomComplet();
            rep = Navigateur.getInstance().getRepertoireCourant().getRepertoire(source);
            
//            Navigateur.getInstance().getRepertoireCourant().setRepertoireParent(repP);
            Navigateur.getInstance().getRepertoireCourant().copier(rep);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        source = parametres[0];
        destination = parametres[1];
    }
    
}
