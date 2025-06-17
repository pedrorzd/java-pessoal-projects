package main.java.com.Model;

public class Produtos {
    private int id;
    private String descricao;
    private double precoEntrada;
    private int precoVenda;
    private String codigo;
    private String fornecedor;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoEntrada() {
        return precoEntrada;
    }

    public void setPrecoEntrada(double precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(int precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
