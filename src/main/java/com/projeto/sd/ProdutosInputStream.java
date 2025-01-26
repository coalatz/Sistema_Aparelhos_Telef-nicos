package com.projeto.sd;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProdutosInputStream extends InputStream {

    private final DataInputStream dataIn;
    private String produtos[];
    private float precos[];

public ProdutosInputStream(InputStream origem, String[] produtos, float[] preco) {
        this.dataIn = new DataInputStream(origem);
        this.produtos = produtos;
        this.precos = preco;
    }

    @Override
    public int read() throws IOException {
        return dataIn.read();
    }
    
    
    
    public void receberDados() throws IOException {
        
        int numeroProdutos = dataIn.readInt();
        System.out.println("Número de produtos: " + numeroProdutos);

        String[] produtos = new String[numeroProdutos];
        Double[] precos = new Double[numeroProdutos];    
        
        for (int i = 0; i < numeroProdutos; i++) {
            int nomeLength = dataIn.readInt();
            byte[] nomeBytes = new byte[nomeLength];
            dataIn.readFully(nomeBytes);
            String nome = new String(nomeBytes);
            double preco = dataIn.readDouble();

            produtos[i] = nome;
            precos[i] = preco;

            System.out.println("Produto " + (i + 1) + ":");
            System.out.println("  Nome: " + nome);
            System.out.println("  Preço: " + preco);
        }
        
        }
    
}
