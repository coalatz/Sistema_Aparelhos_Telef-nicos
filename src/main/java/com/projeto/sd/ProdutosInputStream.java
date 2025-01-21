package com.projeto.sd;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProdutosInputStream extends InputStream {

    private final DataInputStream dataIn;

    public ProdutosInputStream(InputStream origem) {
        this.dataIn = new DataInputStream(origem);
    }

    @Override
    public int read() throws IOException {
        return dataIn.read();
    }

    public void receberDados() throws IOException {
        int numeroProdutos = dataIn.readInt();
        System.out.println("Número de produtos: " + numeroProdutos);

        for (int i = 0; i < numeroProdutos; i++) {
            int nomeLength = dataIn.read();
            byte[] nomeBytes = new byte[nomeLength];
            dataIn.readFully(nomeBytes);
            String nome = new String(nomeBytes);

            double preco = dataIn.readDouble();

            System.out.println("Produto " + (i + 1) + ":");
            System.out.println("  Nome: " + nome);
            System.out.println("  Preço: " + preco);
        }
    }
}
