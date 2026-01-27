package dominio;

import java.util.Arrays;

public class NumerosOpArit {

    private double[] numeros;

    public NumerosOpArit() {}

    public NumerosOpArit(double[] numeros) {
        this.numeros = numeros;
    }

    public double[] getNumeros() {
        return numeros;
    }

    public void setNumeros(double[] numeros) {
        this.numeros = numeros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumerosOpArit that = (NumerosOpArit) o;
        return Arrays.equals(numeros, that.numeros);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numeros);
    }
}