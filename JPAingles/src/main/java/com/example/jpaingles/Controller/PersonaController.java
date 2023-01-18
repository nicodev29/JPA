package com.example.jpaingles.Controller;
import com.example.jpaingles.model.Persona;
import com.example.jpaingles.service.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaServicio personaServicio;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return personaServicio.getPersonas();
    }

    @PostMapping("/personas/alta")
    public String altaPersona(@RequestBody Persona persona) {
        personaServicio.savePersona(persona);
        return "Persona dada de alta";
    }

    //metodo para eliminar una persona con deletemapping

    @DeleteMapping("/personas/baja/{id}")
    public String bajaPersona(@PathVariable Long id) {
        personaServicio.deletePersona(id);
        return "Persona dada de baja";
    }

    //realizar un metodo para modificar los datos de una persona con putmapping y que reciba los datos por el body, no por los parametros
    //verificando si el id ingresado existe en la base de datos
    //si el id no existe, devolver un mensaje de error
    //si el id existe, modificar los datos de la persona y devolver la persona modificada

    @PutMapping("/personas/modificar/{id}")
    public Persona modificarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaAModificar = personaServicio.findPersonaById(id);
        if (personaAModificar != null) {
            personaAModificar.setNombre(persona.getNombre());
            personaAModificar.setApellido(persona.getApellido());
            personaAModificar.setEdad(persona.getEdad());
            personaServicio.savePersona(personaAModificar);
            return personaAModificar;
        } else {
            return null;
        }
    }

    //realizar el mismo metodo de modificar persona, pero que reciba los datos por los parametros
    //verificando si el id ingresado existe en la base de datos
    //si el id no existe, devolver un mensaje de error
    //si el id existe, modificar los datos de la persona y devolver la persona modificada

    @PutMapping("/personas/modificar2/{id}")
    public Persona modificarPersona2(@PathVariable Long id,
                                     @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                     @RequestParam(required = false, name = "apellido") String nuevoApellido,
                                     @RequestParam(required = false, name = "edad") int nuevaEdad) {
        Persona personaAModificar = personaServicio.findPersonaById(id);
        if (personaAModificar != null) {
            personaAModificar.setNombre(nuevoNombre);
            personaAModificar.setApellido(nuevoApellido);
            personaAModificar.setEdad(nuevaEdad);
            personaServicio.savePersona(personaAModificar);
            return personaAModificar;
        } else {
            return null;
        }
    }

    //metodo para buscar una persona por id con getmapping
    @GetMapping("/personas/buscar/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return personaServicio.findPersonaById(id);
    }

}
