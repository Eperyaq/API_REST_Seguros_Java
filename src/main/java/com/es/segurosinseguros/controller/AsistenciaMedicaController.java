package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.AsistenciaMedicaDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las operaciones relacionadas con la asistencia médica.
 * Proporciona endpoints para insertar, actualizar, obtener y eliminar registros
 * de asistencia médica en la base de datos.
 */
@RestController
@RequestMapping("/asistencia")
public class AsistenciaMedicaController {

    @Autowired
    private AsistenciaService service;

    /**
     * Inserta un nuevo registro de asistencia médica.
     *
     * @param asistenciaMedicaDto Datos de la asistencia médica a insertar.
     * @return ResponseEntity con el objeto creado y el estado HTTP correspondiente.
     * @throws BadRequestException Si los datos proporcionados son inválidos.
     */
    @PostMapping("/")
    public ResponseEntity<?> insert(
            @RequestBody AsistenciaMedicaDto asistenciaMedicaDto
    ){
        if (asistenciaMedicaDto == null){
            throw new BadRequestException("Datos invalidos");
        }

        AsistenciaMedicaDto asistenciaDto = service.insert(asistenciaMedicaDto);

        if (asistenciaDto == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(asistenciaDto, HttpStatus.CREATED);
        }
    }

    /**
     * Actualiza un registro de asistencia médica existente por su ID.
     *
     * @param id ID del registro de asistencia médica a actualizar.
     * @param cuerpoACambiar Nuevos datos para actualizar el registro.
     * @return ResponseEntity con el objeto actualizado y el estado HTTP correspondiente.
     * @throws BadRequestException Si el ID o los datos proporcionados son inválidos.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody AsistenciaMedicaDto cuerpoACambiar
    ){
        if (id.isEmpty() || id == null){
            throw new BadRequestException("Error, id inválido");
        } else if (cuerpoACambiar == null) {
            throw new BadRequestException("Datos invalidos");
        } else {
            AsistenciaMedicaDto asistDto = service.update(id, cuerpoACambiar);

            if (asistDto == null){
                throw new BadRequestException("No se ha podido updatear en la base de datos");
            } else {
                return new ResponseEntity<>(asistDto, HttpStatus.OK);
            }
        }
    }

    /**
     * Obtiene un registro de asistencia médica por su ID.
     *
     * @param id ID del registro de asistencia médica a obtener.
     * @return ResponseEntity con el objeto correspondiente y el estado HTTP.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable String id
    ){
        if (id.isBlank() || id == null){
            throw new BadRequestException("Datos invalidos");
        }

        AsistenciaMedicaDto asistenciaDto = service.getById(id);

        if (asistenciaDto == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(asistenciaDto, HttpStatus.OK);
        }
    }

    /**
     * Obtiene todos los registros de asistencia médica.
     *
     * @return ResponseEntity con una lista de todos los registros de asistencia médica.
     */
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<AsistenciaMedicaDto> asistenciaDtos = service.getAll();
        return new ResponseEntity<>(asistenciaDtos, HttpStatus.OK);
    }

    /**
     * Elimina un registro de asistencia médica por su ID.
     *
     * @param id ID del registro de asistencia médica a eliminar.
     * @return ResponseEntity con el estado HTTP correspondiente.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable String id
    ){
        if (id.isBlank() || id == null){
            throw new BadRequestException("Datos invalidos");
        }

        Boolean borrado = service.deleteById(id);

        if (borrado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
