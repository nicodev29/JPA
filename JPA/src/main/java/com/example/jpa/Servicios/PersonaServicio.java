package com.example.jpa.Servicios;
import com.example.jpa.Entidades.Direccion;
import com.example.jpa.Entidades.Mascota;
import com.example.jpa.Entidades.Persona;
import com.example.jpa.Persistencia.PersonaDAO;
import com.example.jpa.enums.Rol;
import java.util.Date;
import java.util.List;

public class PersonaServicio {

    private DireccionServicio direccionServicio;
    private MascotaServicio mascotaServicio;
    private final PersonaDAO DAO;

    public PersonaServicio() {
        this.DAO = new PersonaDAO();
    }

    public void setServicios(DireccionServicio direccionServicio, MascotaServicio mascotaServicio) {
        this.direccionServicio = direccionServicio;
        this.mascotaServicio = mascotaServicio;
    }

    // este método persiste un registro de tipo Persona en la base de datos
    // a través del método guardar() de la clase DAO.
    public Persona crearPersona(String nombre, String apellido, String dni, Date nacimiento, Rol rol, Direccion direccion, List<Mascota> mascotas) {

        Persona persona = new Persona();
        try {
            persona.setApellido(apellido);
            persona.setNombre(nombre);
            persona.setDni(dni);
            persona.setNacimiento(nacimiento);
            persona.setRol(rol);
            persona.setMascotas(mascotas);
            persona.setDireccion(direccion);

            DAO.guardar(persona);
            return persona;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Persona buscarPorDni(String dni) {
        try {
            return DAO.buscarPorDNI(dni);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorDni(String dni) {
        try {
            DAO.eliminar(dni);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Persona> listarPersonas() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public  List<Persona> buscarPorPaisYProvincia(String pais, String provincia) {
        try {
            return DAO.buscarPorPaisYProvincia(pais, provincia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}