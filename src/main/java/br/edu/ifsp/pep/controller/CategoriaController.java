/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.entity.Categoria;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable {

    @Inject
    private CategoriaDAO categoriaDAO;

    private Categoria categoria = new Categoria();
    private Categoria categoriaSelecionada;

    private List<Categoria> categorias;

    public void remover() {
        if (categoriaSelecionada != null) {
            System.out.println("Removendo ccategoria selecionada.");
            categoriaDAO.excluir(categoriaSelecionada);
            categorias = null;

            Mensagem.sucesso("categoria exclucída.");
        } else {
            Mensagem.atencao("Selecione umca categoria.");
        }
    }

    public void prepararCadastro() {
        System.out.println("teste");
        System.out.println(categorias.size());
    }

    public String adicionar() {

        categoriaDAO.inserir(categoria);

        categorias = null;

        //Criar categoria
        this.categoria = new Categoria();

        Mensagem.sucesso("categoria cadastradca.");

        return null;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

}
