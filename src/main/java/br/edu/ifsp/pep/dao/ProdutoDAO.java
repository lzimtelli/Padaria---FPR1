/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class ProdutoDAO extends AbstractDAO<Produto> {

    public List<Produto> buscarTodos() {
        return em.createNamedQuery("Produto.buscaTodos", Produto.class)
                .getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {

        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscaPorNome", Produto.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}
