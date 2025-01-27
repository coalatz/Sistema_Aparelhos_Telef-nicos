package com.projeto.sd.questao0102;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor aguardando conexão...");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Conexão recebida.");

                DataInputStream dataIn = new DataInputStream(socket.getInputStream());

                int numProdutos = dataIn.readInt();

                ProdutosInputStream prodInt = new ProdutosInputStream(dataIn);
                prodInt.receberDados();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
