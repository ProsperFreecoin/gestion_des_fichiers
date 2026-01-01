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
public class CmMv extends Commande{
    private String source;
    private String destination ;
    private Repertoire rep ;
    @Override
    public void executer() {
        try {
            rep = Navigateur.getInstance().getRepertoireCourant().getRepertoire(source);
            new Repertoire(destination,rep);
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
