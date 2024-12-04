package com.es.segurosinseguros.dto;

/**
 * Clase que representa un Seguro en el sistema.
 * Contiene información personal del asegurado, como su NIF, nombre, edad,
 * número de hijos, estado civil, entre otros.
 */
public class SeguroDto {

    private long id;
    private String nif;
    private String nombre;
    private String ape1;
    private String ape2;
    private int edad;
    private int numHijos;
    private String sexo;
    private boolean casado;
    private boolean embarazada;

    /**
     * Constructor por defecto.
     */
    public SeguroDto() {}

    /**
     * Obtiene el identificador único del seguro.
     * @return el ID del seguro.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el identificador único del seguro.
     * @param id el ID del seguro.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el NIF del asegurado.
     * @return el NIF del asegurado.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del asegurado.
     * @param nif el NIF del asegurado.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del asegurado.
     * @return el nombre del asegurado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del asegurado.
     * @param nombre el nombre del asegurado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el primer apellido del asegurado.
     * @return el primer apellido del asegurado.
     */
    public String getApe1() {
        return ape1;
    }

    /**
     * Establece el primer apellido del asegurado.
     * @param ape1 el primer apellido del asegurado.
     */
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    /**
     * Obtiene el segundo apellido del asegurado.
     * @return el segundo apellido del asegurado.
     */
    public String getApe2() {
        return ape2;
    }

    /**
     * Establece el segundo apellido del asegurado.
     * @param ape2 el segundo apellido del asegurado.
     */
    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    /**
     * Obtiene la edad del asegurado.
     * @return la edad del asegurado.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del asegurado.
     * @param edad la edad del asegurado.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el número de hijos del asegurado.
     * @return el número de hijos del asegurado.
     */
    public int getNumHijos() {
        return numHijos;
    }

    /**
     * Establece el número de hijos del asegurado.
     * @param numHijos el número de hijos del asegurado.
     */
    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    /**
     * Obtiene el sexo del asegurado.
     * @return el sexo del asegurado.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del asegurado.
     * @param sexo el sexo del asegurado.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Indica si el asegurado está casado.
     * @return {@code true} si está casado; {@code false} en caso contrario.
     */
    public boolean isCasado() {
        return casado;
    }

    /**
     * Establece el estado civil del asegurado.
     * @param casado {@code true} si está casado; {@code false} en caso contrario.
     */
    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    /**
     * Indica si el asegurado está embarazada.
     * @return {@code true} si está embarazada; {@code false} en caso contrario.
     */
    public boolean isEmbarazada() {
        return embarazada;
    }

    /**
     * Establece si el asegurado está embarazada.
     * @param embarazada {@code true} si está embarazada; {@code false} en caso contrario.
     */
    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }
}
