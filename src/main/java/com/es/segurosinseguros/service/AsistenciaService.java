package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.AsistenciaMedicaDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.ValidarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que maneja las operaciones relacionadas con la asistencia médica.
 */
@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaMedicaRepository repository;

    /**
     * Inserta una nueva asistencia médica en el sistema.
     *
     * @param cuerpo DTO que contiene la información de la asistencia médica a insertar.
     * @return El DTO de la asistencia médica insertada.
     * @throws BadRequestException Si los datos proporcionados son inválidos.
     */
    public AsistenciaMedicaDto insert(AsistenciaMedicaDto cuerpo) {
        StringBuilder mensajeError = new StringBuilder();

        if (ValidarDatos.validarAsist(cuerpo, mensajeError)) {
            repository.save(Mapper.DtoToEntityAsistencia(cuerpo));
            return cuerpo;
        } else {
            throw new BadRequestException(mensajeError.toString());
        }
    }

    /**
     * Actualiza una asistencia médica existente.
     *
     * @param id            ID de la asistencia médica a actualizar.
     * @param cuerpoACambiar DTO con los nuevos datos de la asistencia médica.
     * @return El DTO de la asistencia médica actualizada.
     * @throws BadRequestException Si el ID o los datos proporcionados son inválidos.
     * @throws NotFoundException   Si no se encuentra la asistencia médica.
     */
    public AsistenciaMedicaDto update(String id, AsistenciaMedicaDto cuerpoACambiar) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        AsistenciaMedica asist = repository.findById(idL).orElse(null);

        if (asist == null) {
            throw new NotFoundException("El seguro no se encuentra.");
        } else {
            asist.setExplicacion(cuerpoACambiar.getExplicacion());
            asist.setFecha(cuerpoACambiar.getFecha());
            asist.setHora(cuerpoACambiar.getHora());
            asist.setImporte(cuerpoACambiar.getImporte());
            asist.setLugar(cuerpoACambiar.getLugar());
            asist.setBreveDescripcion(cuerpoACambiar.getBreveDescripcion());
            asist.setTipoAsistencia(cuerpoACambiar.getTipoAsistencia());

            repository.save(asist);

            return Mapper.EntityToDtoAsistencia(asist);
        }
    }

    /**
     * Obtiene una asistencia médica por su ID.
     *
     * @param id ID de la asistencia médica a buscar.
     * @return El DTO de la asistencia médica encontrada.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     * @throws NotFoundException   Si no se encuentra la asistencia médica.
     */
    public AsistenciaMedicaDto getById(String id) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        AsistenciaMedica asistencia = repository.findById(idL).orElse(null);

        if (asistencia == null) {
            throw new NotFoundException("Asistencia no encontrada");
        } else {
            return Mapper.EntityToDtoAsistencia(asistencia);
        }
    }

    /**
     * Obtiene todas las asistencias médicas.
     *
     * @return Lista de DTOs con las asistencias médicas.
     * @throws NotFoundException Si no se encuentran asistencias médicas.
     */
    public List<AsistenciaMedicaDto> getAll() {
        List<AsistenciaMedica> asistencias = repository.findAll();

        if (asistencias == null) {
            throw new NotFoundException("Asistencias no encontradas");
        } else {
            ArrayList<AsistenciaMedicaDto> listaDtos = new ArrayList<>();
            asistencias.forEach(asistencia -> listaDtos.add(Mapper.EntityToDtoAsistencia(asistencia)));
            return listaDtos;
        }
    }

    /**
     * Elimina una asistencia médica por su ID.
     *
     * @param id ID de la asistencia médica a eliminar.
     * @return true si la asistencia médica fue eliminada exitosamente, false de lo contrario.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     * @throws NotFoundException   Si no se encuentra la asistencia médica.
     */
    public boolean deleteById(String id) {
        Long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("id no válido");
        }

        AsistenciaMedica asistencia = repository.findById(idL).orElse(null);

        if (asistencia == null) {
            throw new NotFoundException("Asistencia no encontrada.");
        }

        repository.deleteById(idL);

        AsistenciaMedica asistenciaBorrada = repository.findById(idL).orElse(null);

        return asistenciaBorrada == null;
    }
}
