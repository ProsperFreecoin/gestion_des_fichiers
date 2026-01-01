/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author freecoin
 */
public abstract class Fichier implements Serializable{
    
    public final static String chemin = "C:\\Users\\USER\\Downloads\\serial\\ert.ser";
    private static Repertoire root = new Repertoire("",null);
    private LocalDateTime dateCreation;
    private String nom;
    private Repertoire repertoireParent;
    
    
    public Fichier(){
        this.dateCreation = LocalDateTime.now();
    }
    public Fichier(String nom){
        this();
        this.nom = nom;
    }
    public Fichier(String nom , Repertoire repertoireParent){
        this(nom);
        this.repertoireParent = repertoireParent;
        if(repertoireParent != null){
           this.repertoireParent.getFichiers().add(this); 
        }
    }
    
    public Fichier(Fichier fichier){
        this();
        this.nom = fichier.nom;
        this.repertoireParent = fichier.repertoireParent;
    }
    
     public static void sauvegarder() throws Exception{
       FileOutputStream  fichier = new FileOutputStream(Fichier.chemin);
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
       objectOutputStream.writeObject(root);
    }
    
    public static void restaurer() {
        try {
            FileInputStream fichier = new FileInputStream(Fichier.chemin);
            ObjectInputStream objectInputStream = new ObjectInputStream(fichier);   
            root = (Repertoire)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
           
        }catch (IOException e) {
            
        }catch (ClassNotFoundException e){
            
        }   
    }
    
    public abstract boolean estRepertoire();
    
    
    public static Repertoire getRoot(){
        return root;
    }
    
    public abstract int getTaille();
    public String getNomComplet(){
        if(getRepertoireParent() == null){
            return this.nom;
        }
        return getRepertoireParent().getNomComplet() + "/" + this.nom;
    }
    
    public String getNom(){
        return this.nom;
    }

    public Repertoire getRepertoireParent() {
        return repertoireParent;
    }
    
    public void setRepertoireParent(Repertoire rep) {
        this.repertoireParent = rep;
    }
}
