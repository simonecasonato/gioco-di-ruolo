import java.util.Vector;
import java.util.Scanner;

public class Personaggio extends Entita {
    private String nome;
    Vector<Item> inventario = new Vector<Item>();
    private int puntiVita;
    private int armaEquipaggiata;
    private int maxVita;

    public Personaggio(String nome, int dadi, int tipoDado) {
        this.nome = nome;
        for (int i = 0; i < dadi; i++) {
            puntiVita += (int) (Math.random() * tipoDado + 1);
        }
        this.maxVita = puntiVita;
    }

    public String getNome() {
        return nome;
    }

    public void inserimento(Arma arma) {
        inventario.addElement(arma);
    }

    public void inserimento(PozioneVita pozione) {
        inventario.addElement(pozione);
    }

    public void stampa() {

        for (int i = 0; i < inventario.size(); i++) {

            System.out.println("elemento " + i + " : " + inventario.elementAt(i));
        }

    }

    public int attacca(int arma) {
        Arma armaUsata = (Arma) inventario.get(arma);
        return armaUsata.getDanno();
    }

    public void equipaggiare() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("Item in posizione " + i + " :" + inventario.elementAt(i));
        }
        do {
            System.err.println("Inserisci la tua scelta per l'arma: ");
            armaEquipaggiata = sc.nextInt();
            if (inventario.elementAt(armaEquipaggiata) instanceof Arma) {
                System.out.println("Arma scelta: " + inventario.elementAt(armaEquipaggiata));
            } else {
                System.out.println("Non hai scelto un'arma");
            }
        } while (inventario.elementAt(armaEquipaggiata) instanceof Arma == false);
    }

    public void cura(int i) {
        int t = 0;
        if (i < inventario.size() && inventario.elementAt(i) instanceof PozioneVita) {
            puntiVita += ((PozioneVita) inventario.elementAt(i)).cura();
            t = puntiVita;
            if (t > maxVita) {
                t -= maxVita;
                puntiVita -= t;
            }
            System.out.println("Vita attuale: " + puntiVita);
        }

    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public int getNumeroArmaEquipaggiata() {
        return armaEquipaggiata;
    }

    public Item getArmaEquipaggiata(int arma) {
        return inventario.elementAt(arma);
    }

    public int ferimentro(int danno) {
        System.out.println("Mostro ha attaccato ed ha inflitto " + danno + " danni a " + nome);
        puntiVita -= danno;
        return puntiVita;
    }

    public void togliVector(int n) {
        inventario.remove(n);
    }

    public void setPuntiVita(int pv) {
        puntiVita = pv;
    }
}