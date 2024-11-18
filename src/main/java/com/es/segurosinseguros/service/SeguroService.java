package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.ValidarDatos;
import com.es.segurosinseguros.utils.ValidarNif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;


    public SeguroDto getById(String id){

        Long idL;

        try {
            idL = Long.parseLong(id);

        }catch (NumberFormatException e){
            throw new BadRequestException("id no válido");
        }

        Seguro s = repository.findById(idL).orElse(null);

        if (s == null){
            throw new NotFoundException("Seguro no encontrado");
        }else {
            return Mapper.EntityToDto(s);
        }

    }

    public List<SeguroDto> getAll(){

        List<Seguro> listaSeguros = repository.findAll();

        if (listaSeguros == null){
            throw new NotFoundException("Ningun seguro encontrado.");
        }else {
            ArrayList<SeguroDto> listaDtos = new ArrayList<>();

             listaSeguros.forEach(seguro -> listaDtos.add(Mapper.EntityToDto(seguro)));

             return listaDtos;
        }

    }

    public SeguroDto insert(SeguroDto cuerpo){

        StringBuilder mensajeError = new StringBuilder(); // Creo el stringBuilder para los errores que me pueda dar el validador de datos
        if (
                ValidarNif.validarNIF(cuerpo.getNif()) && ValidarDatos.validar(cuerpo, mensajeError)
        ){
            repository.save(Mapper.DtoToEntity(cuerpo));

            return cuerpo;
        }else {
            throw new BadRequestException( mensajeError.toString());
        }
    }

    public boolean delete(String id){
        Long idL;

        try {
            idL = Long.parseLong(id);

        }catch (NumberFormatException e){
            throw new BadRequestException("id no válido");
        }

        Seguro seg = repository.findById(idL).orElse(null);

        if (seg == null){
            throw new NotFoundException("Seguro no encontrado puede que ya borrado");
        }

        repository.delete(seg);

        Seguro seguroBorrado = repository.findById(idL).orElse(null);

        if (seguroBorrado == null){
            return true;
        } else {
            return false;
        }


    }


    public SeguroDto update(String id, SeguroDto cuerpoACambiar){

        Long idL;

        try {
            idL = Long.parseLong(id);

        }catch (NumberFormatException e){
            throw new BadRequestException("id no válido");
        }

        Seguro seguro = repository.findById(idL).orElse(null);

        if (seguro == null){
            throw new NotFoundException("El seguro no se encuentra.");
        }else {
            seguro.setNif(cuerpoACambiar.getNif());
            seguro.setNombre(cuerpoACambiar.getNombre());
            seguro.setApe1(cuerpoACambiar.getApe1());
            seguro.setApe2(cuerpoACambiar.getApe2());
            seguro.setEdad(cuerpoACambiar.getEdad());
            seguro.setNumHijos(cuerpoACambiar.getNumHijos());
            seguro.setCasado(cuerpoACambiar.isCasado());
            seguro.setSexo(cuerpoACambiar.getSexo());
            seguro.setEmbarazada(cuerpoACambiar.isEmbarazada());

            repository.save(seguro);

            return Mapper.EntityToDto(seguro);

        }


    }
}
