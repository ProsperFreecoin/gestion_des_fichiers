/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichier;

import gestion.fichier.cli.Commande;
import gestion.fichier.cli.Navigateur;
import gestion.fichier.cli.ParseurCommande;
import gestion.fichier.metier.Repertoire;
import java.util.Scanner;

/**
 *
 * @author freecoin
 */
public class Main {
    private static Scanner clavier = new Scanner(System.in);
    private static ParseurCommande parseur = new ParseurCommande();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          System.out.println("Bonjour!!!");
          Repertoire root = new Repertoire("/",null);
          Navigateur.getInstance().setRepertoireCourant(root);
        while(true){
            String chemin = "free@deb:"
                    +Navigateur.getInstance().getRepertoireCourant().getNomComplet()
                    +"$";
            System.out.print(chemin);
            String strCmde = clavier.nextLine();
            Commande commande = parseur.parser(strCmde);
            commande.executer();
        }
    }
    
}
