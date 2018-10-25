/*
 * 
 * project: E-commerce eletrônico
 * course: Programação para Web I
 * university: Universidade Federal do Ceará - UFC
 * credits (github): heldercostaa
 * 
 */
package modelo.categoria;

import java.util.List;

/**
 *
 * @author helder
 */
public class CategoriaNegocio {

    public boolean inserir(int id, String descricao) {
        CategoriaDAO dao = new CategoriaDAO();
        return dao.inserir(id, descricao);
    }

    public boolean alterar(int id, String descricao) {
        CategoriaDAO dao = new CategoriaDAO();
        return dao.alterar(id, descricao);
    }

    public boolean excluir(int id) {
        CategoriaDAO dao = new CategoriaDAO();
        return dao.excluir(id);
    }
    
    public Categoria obterCategoria(int id) {
        CategoriaDAO dao = new CategoriaDAO();
        return dao.obterCategoria(id);
    }

    public List<Categoria> obterTodos() {
        CategoriaDAO dao = new CategoriaDAO();
        return dao.obterTodos();
    }
}
