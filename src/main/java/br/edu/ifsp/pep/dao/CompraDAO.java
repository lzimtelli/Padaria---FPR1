/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entity.Compra;
import br.edu.ifsp.pep.entity.Fornecedor;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class CompraDAO extends AbstractDAO<Compra>{
      
    public List<Compra> buscarTodas() {
        return em.createNamedQuery("Compra.buscaTodas", Compra.class)
                .getResultList();

    }

    public List<Compra> buscarPorData(LocalDate dataInicio, LocalDate dataFim) {
        TypedQuery<Compra> query = em.createNamedQuery("Compra.buscarPorData", Compra.class);
        query.setParameter("datainicio", dataInicio);
        query.setParameter("datafim", dataFim);

        return query.getResultList();
    }
    
    public List<Compra>buscaPorFornecedor(Fornecedor fornecedor){
          TypedQuery<Compra> query = em.createNamedQuery("Compra.buscaPorFornecedor", Compra.class);
        query.setParameter("fornecedor", fornecedor);

        return query.getResultList();   
    } 
}
