/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Pessoa;
import br.edu.ifsp.pep.entity.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class VendaDAO extends AbstractDAO<Venda> {

    public List<Venda> buscarTodas() {
        return em.createNamedQuery("Pessoa.buscarTodas", Venda.class)
                .getResultList();

    }

    public List<Venda> buscarPorData(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Venda> query = em.createNamedQuery("Venda.buscarPorData", Venda.class);
        query.setParameter("datainicio", dataInicio);
        query.setParameter("datafim", dataFim);

        return query.getResultList();
    }
    
    public List<Venda>buscaPorUsuario(Pessoa pessoa){
          TypedQuery<Venda> query = em.createNamedQuery("Venda.buscaPorUsuario", Venda.class);
        query.setParameter("pessoa", pessoa);

        return query.getResultList();   
    } 
}
