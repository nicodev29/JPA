package com.example.jpaingles.service;
import com.example.jpaingles.model.Persona;
import java.util.List;

public interface IPersonaServicio {

    //generar metodos crud

    //Lectura de todas las personas
     List<Persona> getPersonas();

    //Alta
     void savePersona(Persona persona);

    //Baja
     void deletePersona(Long id);

    //Encontrar una persona por Id
     Persona findPersonaById(Long id);

     void modificarPersona (Long idOriginal, Long nuevoId,
                                  String nuevoNombre,
                                  String nuevoApellido,
                                  int nuevaEdad);

}
