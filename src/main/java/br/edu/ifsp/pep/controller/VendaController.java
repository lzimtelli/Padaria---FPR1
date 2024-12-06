package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CarrinhoDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.entity.Carrinho;
import br.edu.ifsp.pep.entity.ItemCarrinho;
import br.edu.ifsp.pep.entity.ItemVenda;
import br.edu.ifsp.pep.entity.Produto;
import br.edu.ifsp.pep.entity.Venda;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class VendaController implements Serializable {

    @Inject
    private CarrinhoDAO carrinhoDAO;

    @Inject
    private ProdutoDAO produtoDAO;

    @Inject
    private VendaDAO vendaDAO;

    @Inject
    private LoginController loginController;

    private Carrinho carrinho;

    private List<Produto> produtos;

    private List<ItemCarrinho> itensCarrinho = new ArrayList<>();

    public void adicionarProdutoAoCarrinho(Produto produto, int quantidade) {
        if (loginController.getPessoaAutenticada() == null) {
            Mensagem.erro("Usuário precisa estar logado.");
            return;
        }

        inicializarCarrinho();

        boolean produtoJaAdicionado = false;
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                produtoJaAdicionado = true;
                break;
            }
        }

        if (!produtoJaAdicionado) {
            adicionarNovoItemCarrinho(produto, quantidade);
        }

        carrinho.setItensCarrinho(itensCarrinho);
        carrinhoDAO.alterar(carrinho);

        Mensagem.sucesso("Produto adicionado ao carrinho com sucesso.");
    }

    private void inicializarCarrinho() {
        if (carrinho == null) {
            carrinho = carrinhoDAO.buscaCarrinhoPessoa(loginController.getPessoaAutenticada());
            if (carrinho == null) {
                carrinho = new Carrinho();
                carrinho.setPessoa(loginController.getPessoaAutenticada());
                carrinhoDAO.inserir(carrinho);
            }
            if (carrinho.getItensCarrinho() == null) {
                itensCarrinho = new ArrayList<>();
            } else {
                itensCarrinho = carrinho.getItensCarrinho();
            }
        }
    }

    private void adicionarNovoItemCarrinho(Produto produto, int quantidade) {
        ItemCarrinho novoItem = new ItemCarrinho();
        novoItem.setCarrinho(carrinho);
        novoItem.setProduto(produto);
        novoItem.setQuantidade(quantidade);
        itensCarrinho.add(novoItem);
    }

    public void finalizarVenda() {
        if (carrinho == null || itensCarrinho.isEmpty()) {
            Mensagem.erro("O carrinho está vazio.");
            return;
        }

        try {
            Venda venda = criarVenda();
            vendaDAO.inserir(venda);

            itensCarrinho.clear();
            carrinho.setItensCarrinho(itensCarrinho);
            carrinhoDAO.alterar(carrinho);

            Mensagem.sucesso("Venda finalizada com sucesso.");
        } catch (Exception e) {
            Mensagem.erro("Erro ao finalizar a venda: " + e.getMessage());
        }
    }

    private Venda criarVenda() {
        Venda venda = new Venda();
        venda.setPessoa(loginController.getPessoaAutenticada());

        List<ItemVenda> itensVenda = new ArrayList<>();
        for (ItemCarrinho itemCarrinho : itensCarrinho) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setVenda(venda);
            itemVenda.setProdutoVenda(itemCarrinho.getProduto());
            itemVenda.setQuantidade(itemCarrinho.getQuantidade());
            itemVenda.setValorUnitario(itemCarrinho.getProduto().getValorVenda());
            itensVenda.add(itemVenda);
        }

        venda.setItens(itensVenda);
        return venda;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = produtoDAO.buscarTodos();
        }
        return produtos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }
}
