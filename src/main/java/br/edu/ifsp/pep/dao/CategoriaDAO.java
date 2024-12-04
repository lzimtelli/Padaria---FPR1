/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Categoria;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class CategoriaDAO extends AbstractDAO<Categoria> {

    public List<Categoria> buscarTodas() {
        return em.createNamedQuery("Categoria.buscaTodas", Categoria.class)
                .getResultList();
    }
}
