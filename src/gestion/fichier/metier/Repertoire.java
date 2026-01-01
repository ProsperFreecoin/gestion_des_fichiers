/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichier.cli.Navigateur;
import java.io.FileNotFoundException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freecoin
 */
public class Repertoire extends Fichier{
    @Serial
    private static final long serialVersionUID = -897856973823710492L;
    private List<Fichier> fichiers = new ArrayList<>();
    
    public Repertoire(){
        
    }
    public Repertoire(String nom ,Repertoire repertoireParent){
        super(nom, repertoireParent);
    }
    
    public Repertoire(Repertoire rep){
        super(rep);
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

    @Override
    public boolean estRepertoire() {
        return true;
    }
    
    public boolean existeRepertoire(String nom){
       for(Fichier fichier : fichiers){
           if(fichier.getNom().equals(nom) && estRepertoire()){
               return true;
           }
       } 
       return false;
    }
    
    public boolean existeFichier(String nom){
         for(Fichier fichier : fichiers){
           if(fichier.getNom().equals(nom) && !estRepertoire()){
               return true;
           }
       } 
       return false;
    }
    
    public Repertoire getRepertoire(String nom) throws FileNotFoundException{
        if(nom == null){
            return null;
        }
        
        
        for(Fichier fichier : fichiers){
           if(fichier.getNom().equals(nom) && fichier.estRepertoire()){
               return (Repertoire)fichier;
           }
        } 
        throw new FileNotFoundException("Repertoire '" + nom + "' nom trouvé");
    }
    
    public FichierSimple getFichierSimple(String nom) throws FileNotFoundException{
        if(nom == null){
            return null;
        }
        
        
        for(Fichier fichier : fichiers){
           if(fichier.getNom().equals(nom) && !fichier.estRepertoire()){
               return (FichierSimple)fichier;
           }
        } 
        throw new FileNotFoundException("Fichier Simple '" + nom + "' nom trouvé");
    }
    
    public void copier(Repertoire r){
        for(Fichier fic : fichiers){
            if(fic.getNom().equals(r.getNom()) && r.estRepertoire()){
                    //Je conserve la valeur de ce fichier en un repertoire
                    r = (Repertoire)fic;
            }  
        }
    }
    
    public void copier(FichierSimple fi){
        for(Fichier fic : fichiers){
            if(fic.getNom().equals(fi.getNom()) && !fi.estRepertoire()){
                    fi = (FichierSimple)fic;
            }
        }
    }
    
    public void move(Repertoire r){
        for(Fichier fic : fichiers){
            if(fic.getNom().equals(r.getNom()) && r.estRepertoire()){
                r = (Repertoire)fic;
            }
        }
    }
    
    public void supprimer(Repertoire rep){ 
      
    // On retire le répertoire de la liste des fichiers du dossier actuel
    // On utilise removeIf pour éviter les erreurs lors du parcours de la liste des Fichiers 
        boolean estSupprime = fichiers.removeIf(f -> 
            f.getNom().equals(rep.getNom()));

    // Gestion de la navigation via le Singleton
        if (estSupprime) {
        
             // Si l'utilisateur a supprimé le dossier dans lequel il se trouvait :
            if (Navigateur.getInstance().getRepertoireCourant().equals(rep)) {
            // On le fait remonter automatiquement au répertoire parent (this)
                Navigateur.getInstance().setRepertoireCourant(this); 
            }
        }
    }
 
    public void supprimer(FichierSimple fi){ 
      
    // On retire le fichier simple de la liste des fichiers du dossier actuel
    // On utilise removeIf pour éviter les erreurs lors du parcours de la liste des Fichiers 
        fichiers.removeIf(f -> 
            f.getNom().equals(fi.getNom()));
    }
}
