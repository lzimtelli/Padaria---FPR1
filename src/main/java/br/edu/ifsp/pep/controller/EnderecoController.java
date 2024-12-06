/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.EnderecoDAO;
import br.edu.ifsp.pep.entity.Endereco;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
@Named
@ViewScoped
public class EnderecoController implements Serializable{
    
    @Inject
    private EnderecoDAO enderecoDAO;
    
    private Endereco endereco = new Endereco();
    private Endereco enderecoSelecionado;

    private List<Endereco> enderecos;
    
    @Inject
    private LoginController pessoaAutenticada;
    
        public void remover() {
        if (enderecoSelecionado != null) {
            System.out.println("Removendo endereco selecionado");
            enderecoDAO.excluir(enderecoSelecionado);
            enderecos = null;

            Mensagem.sucesso("categoria exclucída.");
        } else {
            Mensagem.atencao("Selecione umca categoria.");
        }
    }

    public void prepararCadastro() {
        System.out.println("teste");
        System.out.println(enderecos.size());
    }

    public String adicionar() {

        enderecoDAO.inserir(endereco);

        enderecos = null;

        this.endereco = new Endereco();

        Mensagem.sucesso("Endereço cadastrado");

        return null;
    }

    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    public List<Endereco> getEnderecos() {
        if(enderecos == null){
            enderecos = enderecoDAO.buscaPorUsuario(pessoaAutenticada.getPessoaAutenticada());
        }
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
}
