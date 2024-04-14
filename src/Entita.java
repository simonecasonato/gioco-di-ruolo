public  abstract class Entita implements Nameable {
    private String nome;
    private int puntiVita;

    public String getNome() {
        return nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }
}