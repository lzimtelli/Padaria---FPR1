package br.edu.ifsp.pep.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carrinho")
@NamedQueries({
    @NamedQuery(name = "Carrinho.buscaAberto", query = "SELECT c FROM Carrinho c WHERE c.pessoa = :pessoa")
})
public class Carrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private Long idCarrinho;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(
            name = "carrinho_produto", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "id_carrinho"), // Chave estrangeira para Carrinho
            inverseJoinColumns = @JoinColumn(name = "id_produto") // Chave estrangeira para Produto
    )
    private List<Produto> produtos;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itensCarrinho = new ArrayList<>();

    public Carrinho() {

    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idCarrinho);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrinho other = (Carrinho) obj;
        return Objects.equals(this.idCarrinho, other.idCarrinho);
    }

}
