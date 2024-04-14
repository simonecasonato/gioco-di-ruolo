//Casonato Simone 4xat
/*Obiettivo:
Creare un gioco di ruolo in Java con l'utilizzo di un'entità comune, 
aggiungere la possibilità di possedere un inventario di oggetti e utilizzare tipi di oggetti come armi e pozioni della vita.

Requisiti:

-Creare un'interfaccia chiamata Nameable con un metodo getNome().

-La classe Entita dovrebbe implementare l'interfaccia Nameable

-Creare una classe Personaggio e una classe Mostro che derivino da Entita

-Implementare una classe Item che rappresenta un oggetto generico all'interno del gioco e implementa l'interfaccia Nameable.

-Creare una classe Arma che eredita da Item.

-Creare una classe PozioneVita che eredita da Item.

-Aggiungere un attributo inventario alla classe Personaggio, rappresentato da un Vector di oggetti Item.

-Modificare la classe Personaggio in modo che possa attaccare utilizzando un'arma dal suo inventario. 
Se l'arma non è presente nell'inventario, attacca a pugni dando 1d4 di danno

Dettagli:

-L'interfaccia Nameable dovrebbe contenere un solo metodo getNome()

-La classe Entita dovrebbe implementare l'interfaccia Nameable e contenere almeno i seguenti attributi:
Nome dell'entità.
Punti vita dell'entità.

-La classe Mostro ha un metodo per infliggere danni.

-La classe Item deve implementare l'interfaccia Nameable. Questa classe rappresenta un oggetto generico all'interno del gioco.

-La classe Arma dovrebbe ereditare da Item e avere almeno i seguenti attributi:
Danni inflitti dall'arma (dadi + modificatore, esempio 1d8+2, 2d6+1, 1d12)

-La classe PozioneVita dovrebbe ereditare da Item e avere almeno i seguenti attributi:
Punti vita aggiunti dalla pozione (sempre a dadi)

-Aggiungere un attributo inventario alla classe Personaggio, rappresentato da un Vector di oggetti Item, 
e un attributo per memorizzare l'arma utilizzata.

-Modificare il metodo attacca nella classe Personaggio in modo che possa attaccare utilizzando un'arma dal suo inventario. 
Se l'arma non è presente nell'inventario, il personaggio deve attaccare con 1d4.

Creare un programma principale (GiocoDnD) che simula uno scontro tra un personaggio e un mostro alla volta, includendo l'utilizzo di oggetti come armi e pozioni della vita.
Un mostro una volta sconfitto può dare al giocatore un item.

Note:

Assicurarsi che l'inventario di un personaggio possa gestire oggetti di tipo Item, consentendo una gestione polimorfica degli oggetti.
Aggiungere messaggi di output informativi durante gli attacchi, l'uso di oggetti e altri eventi significativi.
Utilizza uno switch per poter dare comandia a schermo come: Affrontare un mostro, visualizzare l'inventario, equipaggiare una certa arma, utilizzare una pozione.
Potresti volere utilizzare una classe apposta per il sistema di danni
Per fare diminuire la vita o lo passi come parametro ad un metodo del Personaggio (brutto)
 o crei un sistema di combattimento apposta (un'altra classe) a cui passare Personaggio e Mostro */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int d = 0;
        Arma[] armi = {
                new Arma("pugni", 1, 4, 0),
                new Arma("Spada", 2, 6, 2),
                new Arma("Spadone del cristo", 3, 8, 2),
                new Arma("Ascia", 4, 6, 1),
                new Arma("Alabarda", 5, 10, 2),
                new Arma("Lancia da cavaliere", 2, 12, 2)
        };

        Personaggio p1 = new Personaggio("Player", 5, 8);

        PozioneVita[] pozione = {

                new PozioneVita("Pozione comune", 2, 4, 2),
                new PozioneVita("Pozione non comune", 4, 4, 4),
                new PozioneVita("Pozione rara", 8, 4, 8)

        };

        Mostro[] mostri = {

                new Mostro("Piero", 15),
                new Mostro("Bortolo", 20),
                new Mostro("Toni", 10),
                new Mostro("Pissio", 30)

        };

        Scanner scanner = new Scanner(System.in);

        for (int j = 0; j < armi.length; j++) {
            p1.inserimento(armi[j]);
        }

        for (int j = 0; j < pozione.length; j++) {
            p1.inserimento(pozione[j]);
        }

        int j = 0;
        while (p1.getPuntiVita() > 0 && j < 4) {
            System.out.println("Inserisci: ");
            System.out.println("1- Per attaccare il mostro ");
            System.out.println("2- Per curare  il personaggio ");
            System.out.println("3- Per visualizzare l'inventario ");
            System.out.println("4- Per visualizzare le caratteristiche del mostro ");
            System.out.println("5- Per equipaggiare un'arma ");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println();
                    if (j < mostri.length) {

                        System.out.println("Vita iniziale di " + p1.getNome() + " : " + p1.getPuntiVita());

                        while (p1.getPuntiVita() > 0 && mostri[j].getPuntiVita() > 0) {

                            System.out.println(p1.getNome() + " attacca con : "
                                    + p1.getArmaEquipaggiata(p1.getNumeroArmaEquipaggiata()) + " causando " + d
                                    + " danni");
                            mostri[j].ferimentro(d);
                            p1.setPuntiVita(p1.ferimentro(mostri[j].attacca()));

                        }

                        if (p1.getPuntiVita() <= 0) {
                            System.out.println("la vita " + p1.getNome() + " : 0");
                        } else {
                            System.out.println("la vita di " + p1.getNome() + " : " + p1.getPuntiVita());
                        }

                        if (mostri[j].getPuntiVita() <= 0) {
                            System.out.println("la vita di " + mostri[j].getNome() + ": 0");
                        } else {
                            System.out.println("la vita di " + mostri[j].getNome() + ": " + mostri[j].getPuntiVita());
                        }
                        j++;
                    } else {
                        System.out.println("Hai sconfitto tutti i mostri");
                    }
                    break;

                case 2:
                    System.out.println();
                    int t;
                    p1.stampa();
                    System.out.println();
                    System.out.println("inserisci il numero della pozione da usare: ");
                    t = scanner.nextInt();
                    p1.cura(t);
                    p1.togliVector(t);
                    break;

                case 3:
                    System.out.println();
                    p1.stampa();
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Caratteristiche del mostro:");
                    System.out.println("Nome: " + mostri[j].getNome());
                    System.out.println("Vita: " + mostri[j].getPuntiVita());
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    p1.equipaggiare();
                    d = p1.attacca(p1.getNumeroArmaEquipaggiata());
                    System.out.println();
                    break;

                default:
                    System.out.println();
                    System.out.println("Comando non riconosciuto");
                    System.out.println();
                    break;
            }
            System.out.println();

        }
        if (p1.getPuntiVita() < 1) {
            System.out.println(p1.getNome() + " è morto");
        } else {
            System.out.println("Hai vinto");
        }
    }
}