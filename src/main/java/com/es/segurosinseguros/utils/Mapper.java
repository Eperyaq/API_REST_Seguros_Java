package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDto;
import com.es.segurosinseguros.dto.SeguroDto;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;

public class Mapper {

    public static Seguro DtoToEntity(SeguroDto segDto){

        Seguro s = new Seguro();

        s.setIdSeguro(segDto.getId());
        s.setNif(segDto.getNif());
        s.setEdad(segDto.getEdad());
        s.setNombre(segDto.getNombre());
        s.setApe1(segDto.getApe1());
        s.setApe2(segDto.getApe2());
        s.setCasado(segDto.isCasado());
        s.setEmbarazada(segDto.isEmbarazada());
        s.setSexo(segDto.getSexo());
        s.setNumHijos(segDto.getNumHijos());

        return s;
    }

    public static SeguroDto EntityToDto(Seguro seg){

        SeguroDto sdto = new SeguroDto();

        sdto.setId(seg.getIdSeguro());
        sdto.setNombre(seg.getNombre());
        sdto.setApe1(seg.getApe1());
        sdto.setApe2(seg.getApe2());
        sdto.setNif(seg.getNif());
        sdto.setEdad(seg.getEdad());
        sdto.setNumHijos(seg.getNumHijos());
        sdto.setSexo(seg.getSexo());
        sdto.setCasado(seg.isCasado());
        sdto.setEmbarazada(seg.isEmbarazada());

        return sdto;
    }

    //--------------------------------------------------------------------------------------

    public static AsistenciaMedica DtoToEntityAsistencia(AsistenciaMedicaDto asistenciaMedicaDto) {
        AsistenciaMedica a = new AsistenciaMedica();
        a.setIdAsistenciaMedica(asistenciaMedicaDto.getIdAsistenciaMedica());
        a.setBreveDescripcion(asistenciaMedicaDto.getBreveDescripcion());
        a.setLugar(asistenciaMedicaDto.getLugar());
        a.setExplicacion(asistenciaMedicaDto.getExplicacion());
        a.setTipoAsistencia(asistenciaMedicaDto.getTipoAsistencia());
        a.setFecha(asistenciaMedicaDto.getFecha());
        a.setHora(asistenciaMedicaDto.getHora());
        a.setImporte(asistenciaMedicaDto.getImporte());
        return a;
    }

    public static AsistenciaMedicaDto EntityToDtoAsistencia(AsistenciaMedica asistenciaMedica) {
        AsistenciaMedicaDto asistenciaMedicaDto = new AsistenciaMedicaDto();
        asistenciaMedicaDto.setIdAsistenciaMedica(asistenciaMedica.getIdAsistenciaMedica());
        asistenciaMedicaDto.setBreveDescripcion(asistenciaMedica.getBreveDescripcion());
        asistenciaMedicaDto.setLugar(asistenciaMedica.getLugar());
        asistenciaMedicaDto.setExplicacion(asistenciaMedica.getExplicacion());
        asistenciaMedicaDto.setTipoAsistencia(asistenciaMedica.getTipoAsistencia());
        asistenciaMedicaDto.setFecha(asistenciaMedica.getFecha());
        asistenciaMedicaDto.setHora(asistenciaMedica.getHora());
        asistenciaMedicaDto.setImporte(asistenciaMedica.getImporte());
        return asistenciaMedicaDto;
    }

}
