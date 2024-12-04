package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las operaciones relacionadas con los seguros.
 * Proporciona endpoints para insertar, actualizar, obtener y eliminar registros
 * de seguros en la base de datos.
 */
@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService service;

    /**
     * Obtiene un registro de seguro por su ID.
     *
     * @param id ID del seguro a obtener.
     * @return ResponseEntity con el objeto correspondiente y el estado HTTP.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable String id
    ){
        if (id == null){
            throw new BadRequestException("id no válido");
        } else {
            SeguroDto sdto = service.getById(id);
            return new ResponseEntity<>(sdto, HttpStatus.OK);
        }
    }

    /**
     * Obtiene todos los registros de seguros.
     *
     * @return ResponseEntity con una lista de todos los registros de seguros.
     */
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<SeguroDto> segurosDtos = service.getAll();
        return new ResponseEntity<>(segurosDtos, HttpStatus.OK);
    }

    /**
     * Inserta un nuevo registro de seguro.
     *
     * @param seguroDto Datos del seguro a insertar.
     * @return ResponseEntity con el objeto creado y el estado HTTP correspondiente.
     * @throws BadRequestException Si los datos proporcionados son inválidos.
     */
    @PostMapping("/")
    public ResponseEntity<?> insert(
            @RequestBody SeguroDto seguroDto
    ){
        if (seguroDto == null){
            throw new BadRequestException("El cuerpo es inválido");
        } else {
            SeguroDto seguro = service.insert(seguroDto);

            if (seguro == null){
                throw new BadRequestException("No se ha podido insertar en la base de datos");
            } else {
                return new ResponseEntity<>(seguro, HttpStatus.CREATED);
            }
        }
    }

    /**
     * Elimina un registro de seguro por su ID.
     *
     * @param id ID del seguro a eliminar.
     * @return ResponseEntity con el estado HTTP correspondiente.
     * @throws BadRequestException Si el ID proporcionado es inválido.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable String id
    ){
        if (id == null || id.isEmpty()){
            throw new BadRequestException("Error, id inválido");
        } else {
            SeguroDto segurodto = service.delete(id);

            if (segurodto == null){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    /**
     * Actualiza un registro de seguro existente por su ID.
     *
     * @param id ID del seguro a actualizar.
     * @param cuerpoACambiar Nuevos datos para actualizar el registro.
     * @return ResponseEntity con el objeto actualizado y el estado HTTP correspondiente.
     * @throws BadRequestException Si el ID o los datos proporcionados son inválidos.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody SeguroDto cuerpoACambiar
    ){
        if (id.isEmpty() || id == null){
            throw new BadRequestException("Error, id inválido");
        } else if (cuerpoACambiar == null){
            throw new BadRequestException("Datos invalidos");
        } else {
            SeguroDto segDto = service.update(id, cuerpoACambiar);

            if (segDto == null){
                throw new BadRequestException("No se ha podido updatear en la base de datos");
            } else {
                return new ResponseEntity<>(segDto, HttpStatus.OK);
            }
        }
    }
}
