package OBJETOS;

import java.util.Arrays;
import java.util.Objects;

public class CANCIONES {

    private int id;
    private String[] canciones = {"Don't start now", "Mercy", "Issues", "Toxic", "Mon Amour", "Easy on me"};
    private String[] cantante = {"Dua Lipa", "Shawn Mendes", "Julia Michaels", "Britney Spears", "Aitana", "Adele"};
    private int[] precios = {1000, 990, 1290, 830, 840, 1420};
    private  int[] calificacion = {4, 5, 4, 3, 4, 5};

    public CANCIONES ()
    {

    }

    public CANCIONES(int id, String[] canciones, String[] cantante, int[] precios, int[] calificacion) {
        this.id = id;
        this.canciones = canciones;
        this.cantante = cantante;
        this.precios = precios;
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getCanciones() {
        return canciones;
    }

    public void setCanciones(String[] canciones) {
        this.canciones = canciones;
    }

    public String[] getCantante() {
        return cantante;
    }

    public void setCantante(String[] cantante) {
        this.cantante = cantante;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int[] getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int[] calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CANCIONES canciones1 = (CANCIONES) o;
        return id == canciones1.id && Arrays.equals(canciones, canciones1.canciones) && Arrays.equals(cantante, canciones1.cantante) && Arrays.equals(precios, canciones1.precios) && Arrays.equals(calificacion, canciones1.calificacion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(canciones);
        result = 31 * result + Arrays.hashCode(cantante);
        result = 31 * result + Arrays.hashCode(precios);
        result = 31 * result + Arrays.hashCode(calificacion);
        return result;
    }

    @Override
    public String toString() {
        return "CANCIONES{" +
                "id=" + id +
                ", canciones=" + Arrays.toString(canciones) +
                ", cantante=" + Arrays.toString(cantante) +
                ", precios=" + Arrays.toString(precios) +
                ", calificacion=" + Arrays.toString(calificacion) +
                '}';
    }

    public int anadirAdicional (int valor, int adicional) {
        return valor + adicional;
    }
}
