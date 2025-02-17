package com.projeto.sd.models;

public class Celular extends Produto{

    private int armazenamento;
    private int ram;
    private String sistemaOperacional;

    public Celular (
        String modelo, Float preco, int quantidade, String marca,
        int armazenamento, int ram, String sistemaOperacional ) {
            super( modelo, preco, quantidade, marca);
            this.armazenamento = armazenamento;
            this.ram = ram;
            this.sistemaOperacional = sistemaOperacional;
        }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

        

}
