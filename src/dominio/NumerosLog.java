package dominio;

public class NumerosLog {

    private double numero;

    public NumerosLog(){}

    public NumerosLog(double numero) {
        this.numero = numero;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "NumerosLog{" + "numero=" + numero + '}';
    }

}
