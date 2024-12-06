/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.entity.Categoria;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

/**
 *
 * @author aluno
 */
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter<Categoria> {

    @Override
    public Categoria getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }

        CategoriaDAO dao = CDI.current().select(CategoriaDAO.class).get();
        return dao.buscaPorCod(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Categoria t) {
        return t == null ? null : t.getIdCategoria().toString();

    }

}
