package com.example.jpaingles.service;
import com.example.jpaingles.model.Persona;
import com.example.jpaingles.repository.IPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio implements IPersonaServicio {
    @Autowired
    private IPersonaRepositorio personaRepositorio;


    //Implementamos los metodos de la Interface IPersonaServicio
    @Override
    public List<Persona> getPersonas() {

        List <Persona> listaPersonas = personaRepositorio.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepositorio.deleteById(id);
    }

    @Override
    public Persona findPersonaById(Long id) {
        Persona perso = personaRepositorio.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void modificarPersona (Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //busco  el objeto original
        Persona perso = this.findPersonaById(idOriginal);

        //proceso de modificación a nivel lógico
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);

        //guardar los cambios
        this.savePersona(perso);
    }
}
