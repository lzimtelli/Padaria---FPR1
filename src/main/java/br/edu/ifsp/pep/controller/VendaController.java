package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CarrinhoDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.entity.Carrinho;
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
    private VendaDAO vendaDAO;

    @Inject
    private ProdutoDAO produtoDAO;

    @Inject
    private CarrinhoDAO carrinhoDAO;

    @Inject
    private LoginController loginController; // Injetando o LoginController

    private Venda venda = new Venda();
    private Venda vendaSelecionada;
    private List<ItemVenda> itensVendas = new ArrayList<>();
    private List<Produto> produtos;
    private Produto produtoSelecionado;
    private Carrinho carrinho;

    // Método para adicionar um produto ao carrinho
    public void adicionar(Produto produto) {
        System.out.println("Entrou no método adicionar!");
        this.produtoSelecionado = produto;
        System.out.println("Produto selecionado: " + produtoSelecionado.getDescricao());

        // Verifica se a pessoa está logada
        if (loginController.usuarioLogado()) {
            // Recupera o carrinho associado à pessoa logada
            if (carrinho == null) {
                carrinho = carrinhoDAO.buscaCarrinhoPessoa(loginController.getPessoaAutenticada());
            }

            // Verifica se o produto já está na lista de produtos
            boolean produtoExistente = false;
            for (Produto p : getProdutos()) {
                if (p.equals(produto)) {
                    produtoExistente = true;
                    break;
                }
            }

            // Se o produto não existir na lista de produtos, adiciona
            if (!produtoExistente) {
                produtos.add(produto); // Adiciona o produto à lista de produtos
                Mensagem.sucesso("Produto adicionado à lista de produtos.");
            } else {
                Mensagem.sucesso("Produto já está na lista de produtos.");
            }

            // Atualiza o carrinho no banco de dados
          //  carrinhoDAO.atualizar(carrinho);
        } else {
            Mensagem.erro("Você precisa estar logado para adicionar produtos ao carrinho.");
        }
    }

    // Método para finalizar a venda e transferir os itens para a venda
    public void finalizarCarrinho() {
        if (carrinho != null && !carrinho.getProdutos().isEmpty()) {
            // Adiciona os itens do carrinho à venda
            for (Produto produto : produtos) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setProdutoVenda(produto);
                itemVenda.setQuantidade(1); // Defina a quantidade conforme necessário
              //  carrinho.adicionarItem(itemVenda);
            }

         //   venda.setItens(carrinho.getItens()); // Adiciona os itens do carrinho à venda
            vendaDAO.inserir(venda); // Persiste a venda no banco de dados
           // carrinho.getItens().clear(); // Limpa o carrinho após a finalização
          //  carrinhoDAO.atualizar(carrinho); // Atualiza o carrinho no banco
            Mensagem.sucesso("Venda finalizada com sucesso!");
        } else {
            Mensagem.erro("O carrinho está vazio, adicione produtos antes de finalizar.");
        }
    }

    // Getter e setters
    public VendaDAO getVendaDAO() {
        return vendaDAO;
    }

    public void setVendaDAO(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Venda getVendaSelecionada() {
        return vendaSelecionada;
    }

    public void setVendaSelecionada(Venda vendaSelecionada) {
        this.vendaSelecionada = vendaSelecionada;
    }

    public List<ItemVenda> getItensVendas() {
        return itensVendas;
    }

    public void setItensVendas(List<ItemVenda> itensVendas) {
        this.itensVendas = itensVendas;
    }

    public Carrinho getCarrinho() {
        if (carrinho == null && loginController.usuarioLogado()) {
            carrinho = carrinhoDAO.buscaCarrinhoPessoa(loginController.getPessoaAutenticada());
        }
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = produtoDAO.buscarTodos();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
