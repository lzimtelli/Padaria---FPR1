/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Endereco;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class EnderecoDAO extends AbstractDAO<Endereco> {

    public List<Endereco> buscaPorUsuario(Pessoa pessoa) {
        TypedQuery<Endereco> query = em.createNamedQuery("Endereco.buscarTodosUsuario", Endereco.class);
        query.setParameter("pessoa", pessoa);

        return query.getResultList();
    }
}
