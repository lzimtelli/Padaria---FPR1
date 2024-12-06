/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Categoria;
import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.entity.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
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

    public List<Produto> buscarProdutos(Categoria cat) {

        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscaPorCategoria", Produto.class);
        query.setParameter("cat", cat);
        return query.getResultList();
    }

    public Categoria buscaPorCod(Integer id) {

        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.buscaPorCod", Categoria.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
