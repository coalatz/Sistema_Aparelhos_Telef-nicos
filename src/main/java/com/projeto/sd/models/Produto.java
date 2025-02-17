package com.projeto.sd.models;

import java.io.Serializable;

public abstract class Produto implements Serializable {
    
    
    private String modelo;
    private Float preco;
    private int quantidade;
    private String marca;

    public Produto( String modelo, Float preco, int quantidade, String marca) {
        this.modelo = modelo;
        this.preco = (float)preco;
        this.quantidade = quantidade;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    

    
}
