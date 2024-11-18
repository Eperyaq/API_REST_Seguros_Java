package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDto;

public class ValidarDatos {

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



}
