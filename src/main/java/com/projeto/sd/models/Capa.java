package com.projeto.sd.models;

public class Capa extends Produto {

    private String celularCompativel;
    private String material;

    public Capa(String modelo, Float preco, int quantidade, String marca, String celularCompativel, String material) {
        super(modelo, preco, quantidade, marca);
        this.celularCompativel = celularCompativel;
        this.material = material;
    }

    public String getCelularCompativel() {
        return celularCompativel;
    }

    public void setCelularCompativel(String celularCompativel) {
        this.celularCompativel = celularCompativel;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
