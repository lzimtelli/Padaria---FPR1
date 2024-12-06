package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entity.NivelAcesso;
import br.edu.ifsp.pep.entity.Pessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoa = new Pessoa();
    
    private Pessoa pessoaAutenticada;
    
    private Pessoa pessoaCadastro = new Pessoa();

    public String autenticar() {
        this.pessoaAutenticada = pessoaDAO.autenticar(pessoa.getLogin(), pessoa.getSenha());
        return "/pessoa/meuPerfil";
    }

    public String logout() {
        this.pessoaAutenticada = null;
        return "/index";
    }
    
    public String cadastrarUsuario(){  
        pessoaCadastro.setNivelAcesso(NivelAcesso.Comum);
        pessoaDAO.inserir(pessoaCadastro);
        
        return "/login/login.xhtml";
    }
    
    public String alterarDados(){
        pessoaDAO.alterar(pessoaAutenticada);
        return "/pessoa/meuPerfil";
    }

    public boolean usuarioLogado() {
        return pessoaAutenticada != null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Pessoa getPessoaAutenticada() {
        return pessoaAutenticada;
    }

    public Pessoa getPessoaCadastro() {
        return pessoaCadastro;
    }

    public void setPessoaCadastro(Pessoa pessoaCadastro) {
        this.pessoaCadastro = pessoaCadastro;
    }
}
