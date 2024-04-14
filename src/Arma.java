public class Arma extends Item {
    private Danno danno;
    private String nome;

    public Arma(String nome, Danno danno) {
        this.nome = nome;
        this.danno = danno;
    }

    public Arma(String nome, int d, int t, int m) {
        this.nome = nome;
        this.danno = new Danno(d, t, m);
    }

    public String getNome() {
        return nome;
    }

    public int getDanno() {
        return danno.getRandom();
    }

    public String toString() {
        return nome + " " + danno.toString();
    }
}