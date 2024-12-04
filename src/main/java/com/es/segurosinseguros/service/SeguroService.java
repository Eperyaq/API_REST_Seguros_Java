package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.ValidarDatos;
import com.es.segurosinseguros.utils.ValidarNif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que gestiona las operaciones relacionadas con los seguros.
 */
@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;

    @Autowired
    private AsistenciaMedicaRepository repoAsistencia;

    /**
     * Obtiene un seguro por su ID.
     *
     * @param id ID del seguro a buscar.
     * @return El DTO del seguro encontrado.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     * @throws NotFoundException   Si no se encuentra el seguro.
     */
    public SeguroDto getById(String id) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        Seguro s = repository.findById(idL).orElse(null);

        if (s == null) {
            throw new NotFoundException("Seguro no encontrado");
        } else {
            return Mapper.EntityToDto(s);
        }
    }

    /**
     * Obtiene todos los seguros.
     *
     * @return Lista de DTOs con todos los seguros encontrados.
     * @throws NotFoundException Si no se encuentran seguros.
     */
    public List<SeguroDto> getAll() {
        List<Seguro> listaSeguros = repository.findAll();

        if (listaSeguros == null) {
            throw new NotFoundException("Ningún seguro encontrado.");
        } else {
            ArrayList<SeguroDto> listaDtos = new ArrayList<>();
            listaSeguros.forEach(seguro -> listaDtos.add(Mapper.EntityToDto(seguro)));
            return listaDtos;
        }
    }

    /**
     * Inserta un nuevo seguro.
     *
     * @param cuerpo DTO que contiene los datos del seguro a insertar.
     * @return El DTO del seguro insertado.
     * @throws BadRequestException Si los datos proporcionados son inválidos.
     */
    public SeguroDto insert(SeguroDto cuerpo) {
        StringBuilder mensajeError = new StringBuilder();

        if (ValidarNif.validarNIF(cuerpo.getNif()) && ValidarDatos.validar(cuerpo, mensajeError)) {
            repository.save(Mapper.DtoToEntity(cuerpo));
            return cuerpo;
        } else {
            throw new BadRequestException(mensajeError.toString());
        }
    }

    /**
     * Elimina un seguro por su ID.
     *
     * @param id ID del seguro a eliminar.
     * @return El DTO del seguro eliminado, o null si no se pudo eliminar.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     * @throws NotFoundException   Si no se encuentra el seguro.
     */
    public SeguroDto delete(String id) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        Seguro seg = repository.findById(idL).orElse(null);

        if (seg == null) {
            throw new NotFoundException("Seguro no encontrado, puede que ya esté borrado.");
        }

        List<AsistenciaMedica> asistencias = repoAsistencia.findBySeguro(seg);
        repoAsistencia.deleteAll(asistencias);
        repository.delete(seg);

        Seguro seguroBorrado = repository.findById(idL).orElse(null);
        return seguroBorrado == null ? Mapper.EntityToDto(seg) : null;
    }

    /**
     * Actualiza un seguro existente.
     *
     * @param id             ID del seguro a actualizar.
     * @param cuerpoACambiar DTO con los nuevos datos del seguro.
     * @return El DTO del seguro actualizado.
     * @throws BadRequestException Si el ID o los datos proporcionados son inválidos.
     * @throws NotFoundException   Si no se encuentra el seguro.
     */
    public SeguroDto update(String id, SeguroDto cuerpoACambiar) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        Seguro seguro = repository.findById(idL).orElse(null);

        if (seguro == null) {
            throw new NotFoundException("El seguro no se encuentra.");
        } else {
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
