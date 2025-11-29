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
public class Navigateur {
    private static Navigateur instance;
    private Repertoire repertoireCourant;
    static{
        instance = new Navigateur();
    }
    //Pattern
    private Navigateur(){
        
    }
    public static Navigateur getInstance(){
        return instance;
    }
    
    public Repertoire getRepertoireCourant(){
        return this.repertoireCourant;
    }
    public void setRepertoireCourant(Repertoire repertoire){
        this.repertoireCourant = repertoire;
    }
}
