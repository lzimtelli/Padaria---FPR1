/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.controller.LoginController;
import br.edu.ifsp.pep.entity.Carrinho;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class CarrinhoDAO extends AbstractDAO<Carrinho> {

     public Carrinho buscaCarrinhoPessoa(Pessoa pessoa){
          TypedQuery<Carrinho> query = em.createNamedQuery("Carrinho.buscaAberto", Carrinho.class);
        query.setParameter("pessoa", pessoa);

        return query.getSingleResult();   
    } 
}
