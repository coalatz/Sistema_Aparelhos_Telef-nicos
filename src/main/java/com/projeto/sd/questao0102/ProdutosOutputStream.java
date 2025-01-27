package com.projeto.sd.questao0102;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.projeto.sd.models.Produto;

class ProdutosOutputStream extends OutputStream {

    private final Produto[] produtos;
    private final OutputStream destino;

    public ProdutosOutputStream(Produto[] produtos, OutputStream destino) {
        this.produtos = produtos;
        this.destino = destino;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviarDados() throws IOException {
        DataOutputStream dataOut = new DataOutputStream(destino);

        dataOut.writeInt(produtos.length);

        for (Produto produto : produtos) {
            byte[] nomeBytes = produto.getModelo().getBytes("UTF-8");

            dataOut.writeInt(nomeBytes.length);

            dataOut.write(nomeBytes);

            dataOut.writeDouble(produto.getPreco());
        }
    }
}
