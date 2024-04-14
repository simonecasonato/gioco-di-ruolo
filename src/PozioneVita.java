public class PozioneVita extends Item {
    private String nomePozione;
    private int puntiVita = 0;
    private int dadi;
    private int tipoDado;
    private int m;

    public PozioneVita(String nome, int dadi, int tipoDado, int m) {
        this.nomePozione = nome;
        this.dadi = dadi;
        this.tipoDado = tipoDado;
        this.m = m;
    }

    public String getNome() {
        return nomePozione;
    }

    public int cura() {
        for (int i = 0; i < dadi; i++) {
            puntiVita += (int) (Math.random() * tipoDado + 1);
        }

        return puntiVita + m;
    }

    public String toString() {
        return nomePozione + " " + dadi + "d" + tipoDado + "+" + m;
    }

}