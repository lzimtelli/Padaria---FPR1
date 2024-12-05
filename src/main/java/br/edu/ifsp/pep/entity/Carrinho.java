package br.edu.ifsp.pep.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_cliente", nullable = false)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itemCarrinhos;
    
    // Getters e setters
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

    public List<ItemCarrinho> getItemCarrinhos() {
        return itemCarrinhos;
    }

    public void setItemCarrinhos(List<ItemCarrinho> itemCarrinhos) {
        this.itemCarrinhos = itemCarrinhos;
    }
}
