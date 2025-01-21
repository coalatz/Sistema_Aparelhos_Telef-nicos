package com.projeto.sd.models;

public class PowerBank extends Produto{

    private int capacidade;
    private String tipoConector;


    public PowerBank(String modelo, Float preco, int quantidade, String marca, int capacidade, String tipoConector) {
        super(modelo, preco, quantidade, marca);
        this.capacidade = capacidade;
        this.tipoConector = tipoConector;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public String getTipoConector() {
        return tipoConector;
    }
    public void setTipoConector(String tipoConector) {
        this.tipoConector = tipoConector;
    }

    
}
