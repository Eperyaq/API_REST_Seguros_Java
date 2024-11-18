package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDto;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable String id
    ){
        if (id == null){

            throw new BadRequestException("id no válido");

        }else {
            SeguroDto sdto = service.getById(id);

            ResponseEntity<SeguroDto> respuesta = new ResponseEntity<>(sdto, HttpStatus.OK);

            return respuesta;
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){

        List<SeguroDto> segurosDtos = service.getAll();

        ResponseEntity<List<SeguroDto>> respuesta = new ResponseEntity<>(segurosDtos, HttpStatus.OK);

        return respuesta;

    }

    @PostMapping("/")
    public ResponseEntity<?> insert(
            @RequestBody SeguroDto seguroDto
    ){

        if (seguroDto == null){

            throw new BadRequestException("El cuerpo es inválido");
        }else {

            SeguroDto seguro = service.insert(seguroDto);

            if (seguroDto == null){
                throw new BadRequestException("No se ha podido insertar en la base de datos");
            }else {
                ResponseEntity respuesta = new ResponseEntity(seguro, HttpStatus.OK);

                return respuesta;
            }
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(
            @PathVariable String id
    ){
       if(id == null || id.isEmpty()){
           throw new BadRequestException("Error, id inválido");
       }else {
           Boolean borrado = service.delete(id);

           if (borrado){
               ResponseEntity respuesta = new ResponseEntity<>(HttpStatus.OK);
               return respuesta;
           }else {
               ResponseEntity respuestaNoBorrado = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
               return respuestaNoBorrado;
           }


       }


    }


    @PutMapping("/{id}")
    public ResponseEntity<?>update(
            @PathVariable String id,
            @RequestBody SeguroDto cuerpoACambiar
    ){

        if (id.isEmpty() || id == null){
            throw new BadRequestException("Error, id inválido");

        } else if (cuerpoACambiar == null){

            throw new BadRequestException("Datos invalidos");
        }else {

            SeguroDto segDto = service.update(id,cuerpoACambiar);

            if (segDto == null){
                throw new BadRequestException("No se ha podido updatear en la base de datos");
            }else {
                ResponseEntity respuesta = new ResponseEntity(segDto, HttpStatus.OK);

                return respuesta;
            }
        }

    }
}
