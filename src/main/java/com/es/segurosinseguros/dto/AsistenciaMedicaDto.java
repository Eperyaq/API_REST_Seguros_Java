package com.es.segurosinseguros.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO que representa la información de una asistencia médica.
 */
public class AsistenciaMedicaDto {

    private long idAsistenciaMedica;
    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    private String tipoAsistencia;
    private LocalDate fecha;
    private LocalTime hora;
    private double importe;

    /**
     * Constructor vacío para la clase AsistenciaMedicaDto.
     */
    public AsistenciaMedicaDto() {}

    /**
     * Obtiene el ID de la asistencia médica.
     *
     * @return ID de la asistencia médica.
     */
    public Long getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    /**
     * Establece el ID de la asistencia médica.
     *
     * @param idAsistenciaMedica ID de la asistencia médica.
     */
    public void setIdAsistenciaMedica(Long idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    /**
     * Obtiene la breve descripción de la asistencia médica.
     *
     * @return Breve descripción de la asistencia médica.
     */
    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    /**
     * Establece la breve descripción de la asistencia médica.
     *
     * @param breveDescripcion Breve descripción de la asistencia médica.
     */
    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    /**
     * Obtiene el lugar donde se realizó la asistencia médica.
     *
     * @return Lugar de la asistencia médica.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar donde se realizó la asistencia médica.
     *
     * @param lugar Lugar de la asistencia médica.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la explicación detallada de la asistencia médica.
     *
     * @return Explicación de la asistencia médica.
     */
    public String getExplicacion() {
        return explicacion;
    }

    /**
     * Establece la explicación detallada de la asistencia médica.
     *
     * @param explicacion Explicación de la asistencia médica.
     */
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    /**
     * Obtiene el tipo de asistencia médica.
     *
     * @return Tipo de asistencia médica.
     */
    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    /**
     * Establece el tipo de asistencia médica.
     *
     * @param tipoAsistencia Tipo de asistencia médica.
     */
    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    /**
     * Obtiene la fecha en la que se realizó la asistencia médica.
     *
     * @return Fecha de la asistencia médica.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó la asistencia médica.
     *
     * @param fecha Fecha de la asistencia médica.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora en la que se realizó la asistencia médica.
     *
     * @return Hora de la asistencia médica.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora en la que se realizó la asistencia médica.
     *
     * @param hora Hora de la asistencia médica.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el importe asociado a la asistencia médica.
     *
     * @return Importe de la asistencia médica.
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe asociado a la asistencia médica.
     *
     * @param importe Importe de la asistencia médica.
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
}
