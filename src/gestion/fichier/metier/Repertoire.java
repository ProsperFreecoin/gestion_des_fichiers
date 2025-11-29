/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freecoin
 */
public class Repertoire extends Fichier{
    private List<Fichier> fichiers = new ArrayList<>();
    
    public Repertoire(){
        
    }
    public Repertoire(String nom ,Repertoire repertoireParent){
        super(nom, repertoireParent);
    }
    
    public void ajouterRepertoire(String nom){
        new Repertoire(nom,this);    
    }
    public void ajouterFichierSimple(String nom){
        new FichierSimple(nom,this);    
    }
    public void afficherContenu(){
        for(Fichier fichier : fichiers) {
            System.out.println(fichier.getNom() + "\t");
        }   
    }
    
    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier fichier : getFichiers()) {
            taille += fichier.getTaille();
        }
        return taille;
    }

    public List<Fichier> getFichiers() {
        return this.fichiers;
    }
    public void setFichiers(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }
    
}
