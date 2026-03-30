package tests;

import java.time.LocalDate;
import java.util.List;

import livres.*;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", "Canada");
        Auteur john = new Auteur("John", "Smith", "Etats-Unis");

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", "Canada"));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", "France"));
        System.out.println("Livres de Jacques: " + resultat);
    }

    private void testPays(){

        System.out.println("\n-----Tests de la classe Pays-----------");

        // Pays valide
        Pays canada = new Pays("Canada", "CAN");
        System.out.println(canada);

        // Pays invalide (code pas 3 lettres majuscules)
        Pays france = new Pays("France", "fr");
        System.out.println(france);

        // Lier un pays à un auteur
        Auteur alexandru = new Auteur("Alexandru", "Ciobanu", "CAN");
        alexandru.setPays(canada);

        // Lier un pays non valide à un auteur valide
        Auteur julian = new Auteur("Julian", "Dupont", "FRA")
        julian.setPays(france)

        System.out.println(alexandru);
        System.out.println(julian);
    }

    private void testSerie() {

        System.out.println("\n-----Test Serie-----------");

        Pays canada = new Pays("Canada", "CAN");
        Pays usa = new Pays("Etats-Unis", "USA");

        Auteur a1 = new Auteur("Albertine", "Tremblay", canada);
        Auteur a2 = new Auteur("John", "Smith", usa);

        Ouvrage o1 = new Ouvrage("Livre A", a1);
        Ouvrage o2 = new Ouvrage("Livre B", a2);

        Serie serie = new Serie("Romans");

        // Ajout d’ouvrages
        serie.addOuvrage(o1);
        serie.addOuvrage(o2);

        System.out.println("Après ajout : " + serie.getOuvrages().size());

        // Suppression d’un ouvrage
        serie.removeOuvrage(o1);

        System.out.println("Après suppression : " + serie.getOuvrages().size());
    }

    private void testOuvrageAudio(){

        // Test de constructeur complet
        Ouvrage audio1 = new OuvrageAudio("Podcast Java", alexandru, 60, "numérique");
        System.out.println(audio1);

        // Test du setFormat et setDureeMinutes
        audio1.setFormat("analogique");
        audio1.setDureeMinutes(45);
        System.out.println(audio1);

        // Test pour durée négative
        audio1.setDureeMinutes(-10);
        System.out.println(audio1);
    }


    private void testOuvragePapier() {

        System.out.println("\n-----Test OuvragePapier-----------");

        Pays canada = new Pays("Canada", "CAN");
        Auteur auteur = new Auteur("Albertine", "Tremblay", canada);

        Ouvrage papier = new OuvragePapier("Livre Papier", auteur, 300);
        System.out.println(papier);
    }


}

