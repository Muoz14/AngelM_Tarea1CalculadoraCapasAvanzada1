package dominio;

public class NumerosTrigo {

    private double grados;

    public NumerosTrigo() {}

    public NumerosTrigo(double grados) {
        this.grados = grados;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public double getRadianes() {
        return Math.toRadians(grados);
    }
}