public class Mostro extends Entita {
    private String nome;
    private int puntiVita;

    public Mostro(String nome, int puntiVita) {
        this.nome = nome;
        this.puntiVita = puntiVita;
    }

    public String getNome() {
        return nome;
    }

    public int attacca() {
        int danni = 0;
        for (int i = 0; i < 2; i++) {
            danni += (int) (Math.random() * 4 + 2);
        }
        return danni;
    }

    public int ferimentro(int danno) {
        puntiVita -= danno;
        return puntiVita;
    }

    public int getPuntiVita() {
        return puntiVita;
    }
}