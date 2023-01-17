package com.example.jpa.Persistencia;
import com.example.jpa.Entidades.Direccion;
import jakarta.persistence.Id;

import java.util.List;

public class DireccionDAO extends DAO<Direccion> {
    public void guardar(Direccion direccion) {
        if (direccion.getId() == null) {
            em.persist(direccion);
        } else {
            em.merge(direccion);
        }
    }

    public void eliminar(Direccion direccion) throws Exception {
        Direccion dire = buscarPorId(direccion.getId());
        super.eliminar(dire);
    }

    public Direccion buscarPorId(String id) {
        conectar();
        Direccion direccion = em.find(Direccion.class, id);
        desconectar();
        return direccion;
    }

    public List<Direccion> buscarTodos() {
        conectar();
        List<Direccion> direcciones = em.createQuery("SELECT d FROM Direccion d").getResultList();
        desconectar();
        return direcciones;
    }

}

