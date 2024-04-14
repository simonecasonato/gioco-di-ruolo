public class Danno {
    private int dadi;
    private int tipoDado;
    private int modificatore;

    public Danno(int dadi, int tipoDado, int modificatore) {
        this.dadi = dadi;
        this.tipoDado = tipoDado;
        this.modificatore = modificatore;
    }

    public int getRandom() {
        int Random = 0;
        for (int i = 0; i < dadi; i++) {
            Random += (int) (Math.random() * tipoDado + 1);
        }
        return Random + modificatore;
    }

    public String toString() {
        return dadi + "d" + tipoDado + "+" + modificatore;
    }
}