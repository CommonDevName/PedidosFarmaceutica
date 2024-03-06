package Models;

import java.io.*;
import java.util.ArrayList;

public class Medicamento implements Serializable{ 
    
    private String nombrecomercial,
            sustanciasactivas,
            laboratorio,
            lote,
            fraccion,
            fechacaducidad;
    private int precio;
    
    public Medicamento(String nombrecomercial, String sustanciasactivas, String laboratorio, String lote, String fraccion, String fechacaducidad, int precio){
        this.nombrecomercial = nombrecomercial;
        this.sustanciasactivas = sustanciasactivas;
        this.laboratorio = laboratorio;
        this.lote = lote;
        this.fraccion = fraccion;
        this.fechacaducidad = fechacaducidad;
        this.precio = precio;
    }

    public String getNombreComercial() {
        return nombrecomercial;
    }

    public void setNombreComercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public String getSustanciasactivas() {
        return sustanciasactivas;
    }

    public void setSustanciasactivas(String sustanciasactivas) {
        this.sustanciasactivas = sustanciasactivas;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        this.fraccion = fraccion;
    }

    public String getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(String fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
