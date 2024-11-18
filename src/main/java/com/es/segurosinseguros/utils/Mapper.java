package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDto;
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

}
