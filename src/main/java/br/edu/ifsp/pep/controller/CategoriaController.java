/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.entity.Categoria;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

/**
 *
 * @author User
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable {

    @Inject
    private CategoriaDAO categoriaDAO;

    private Categoria categoriaSelecionada = new Categoria();

    private List<Categoria> categorias;

    public void remover() {
        if (categoriaSelecionada.getIdCategoria() != null) {
            System.out.println("Removendo categoria selecionada.");
            categoriaDAO.excluir(categoriaSelecionada);
            categorias = null;
            categoriaSelecionada = new Categoria();

            Mensagem.sucesso("categoria exclucída.");
        } else {
            Mensagem.atencao("Selecione umca categoria.");
        }
    }

    public void prepararCadastro() {
        System.out.println("sexoooooooooooo");
        categoriaSelecionada = new Categoria();
        System.out.println("teste");
        System.out.println(categorias.size());
    }

    public void adicionar() {
        categoriaDAO.inserir(categoriaSelecionada);
        categorias = null;
        // Criar categoria
        Mensagem.sucesso("categoria cadastradca.");
    }

    public String alterar() {
        categoriaDAO.alterar(categoriaSelecionada);
        categorias = null;
        // Criar categoria
        Mensagem.sucesso("categoria alterada.");

        return null;
    }

    public void save() {
        if (this.categoriaSelecionada.getIdCategoria() == null) {
            this.adicionar();
            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage("Categoria adicionada"));
        } else {
            this.alterar();
            // FacesContext.getCurrentInstance().addMessage(null, new
            // FacesMessage("Categoria Atualizada"));
        }

        PrimeFaces.current().executeScript("PF('manageCategoriaDialog').hide()");
        PrimeFaces.current().ajax().update("form1:tabela", "grow");
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    public List<Categoria> getCategorias() {
        if (categorias == null) {
            categorias = categoriaDAO.buscarTodas();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public boolean hasSelectedCategoria() {
        System.out.println("oiaq");
        if (categoriaSelecionada == null || categoriaSelecionada.getIdCategoria() == null) {
            return false;
        }
        return true;

    }

}
