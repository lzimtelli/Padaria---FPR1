/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Fornecedor;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class FornecedorDAO extends AbstractDAO<Fornecedor> {

    public List<Fornecedor> buscarTodos() {
        return em.createNamedQuery("Fornecedor.buscaTodos", Fornecedor.class)
                .getResultList();

    }

    public List<Fornecedor> buscarPorNome(String nome) {
        TypedQuery<Fornecedor> query = em.createNamedQuery("Fornecedor.buscaPorNome", Fornecedor.class);
        query.setParameter("nome", nome);

        return query.getResultList();
    }

}
