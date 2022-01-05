public class Zalobce {

    final int rok;
    final String jmeno;
    final double castka;

    public Zalobce(int rok, String jmeno, double castka) {
        this.rok = rok;
        this.jmeno = jmeno;
        this.castka = castka;
    }

    public double getCastka() {
        return castka;
    }

    public String getJmeno() {
        return jmeno;
    }
}
