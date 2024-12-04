package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDto;
import com.es.segurosinseguros.dto.SeguroDto;

/**
 * Clase utilitaria para la validación de datos de las entidades del sistema.
 */
public class ValidarDatos {

    /**
     * Valida los datos de un objeto {@link SeguroDto}.
     *
     * @param segDto       el objeto {@link SeguroDto} que se desea validar.
     * @param mensajeError un {@link StringBuilder} para almacenar los mensajes de error en caso de validación fallida.
     * @return {@code true} si los datos son válidos; {@code false} en caso contrario.
     */
    public static boolean validar(SeguroDto segDto, StringBuilder mensajeError) {
        // Validar nombre y apellido
        if (segDto.getNombre() == null || segDto.getNombre().isEmpty()) {
            mensajeError.append("El campo nombre no puede estar vacío.");
            return false;
        }
        if (segDto.getApe1() == null || segDto.getApe1().isEmpty()) {
            mensajeError.append("El campo ape1 no puede estar vacío.");
            return false;
        }

        // Validar edad
        if (segDto.getEdad() <= 0) {
            mensajeError.append("No es posible ser menor de edad para hacer un seguro.");
            return false;
        } else if (segDto.getEdad() < 18) {
            mensajeError.append("El asegurado debe ser mayor de edad.");
            return false;
        }

        // Validar número de hijos
        if (segDto.getNumHijos() < 0 || (!segDto.isCasado() && segDto.getNumHijos() > 0)) {
            mensajeError.append("Un seguro no puede registrar hijos si no está casado.");
            return false;
        }

        // Validar embarazo
        if (segDto.isEmbarazada() && "Hombre".equalsIgnoreCase(segDto.getSexo())) {
            mensajeError.append("El campo embarazada no puede ser true si el asegurado es hombre.");
            return false;
        }

        // Si no hay errores, retorna true
        return true;
    }

    /**
     * Valida los datos de un objeto {@link AsistenciaMedicaDto}.
     *
     * @param asistDto     el objeto {@link AsistenciaMedicaDto} que se desea validar.
     * @param mensajeError un {@link StringBuilder} para almacenar los mensajes de error en caso de validación fallida.
     * @return {@code true} si los datos son válidos; {@code false} en caso contrario.
     */
    public static boolean validarAsist(AsistenciaMedicaDto asistDto, StringBuilder mensajeError) {

        // Validar breveDescripcion
        if (asistDto.getBreveDescripcion() == null || asistDto.getBreveDescripcion().isEmpty()) {
            mensajeError.append("El campo breveDescripcion no puede estar vacío.");
            return false;
        }

        // Validar lugar
        if (asistDto.getLugar() == null || asistDto.getLugar().isEmpty()) {
            mensajeError.append("El campo lugar no puede estar vacío.");
            return false;
        }

        // Validar explicacion
        if (asistDto.getExplicacion() == null || asistDto.getExplicacion().isEmpty()) {
            mensajeError.append("El campo explicacion no puede estar vacío.");
            return false;
        }

        // Validar tipoAsistencia
        if (asistDto.getTipoAsistencia() == null) {
            mensajeError.append("El campo tipoAsistencia no puede ser nulo.");
            return false;
        }

        // Validar fecha
        if (asistDto.getFecha() == null) {
            mensajeError.append("El campo fecha no puede ser nulo.");
            return false;
        }

        // Validar hora
        if (asistDto.getHora() == null) {
            mensajeError.append("El campo hora no puede ser nulo.");
            return false;
        }

        // Validar importe
        if (asistDto.getImporte() <= 0) {
            mensajeError.append("El campo importe debe ser mayor que 0.");
            return false;
        }

        // Si no hay errores, retorna true
        return true;
    }
}
