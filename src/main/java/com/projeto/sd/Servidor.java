package com.projeto.sd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
                System.out.println("Número de produtos: " + numProdutos);

                String[] produtos = new String[numProdutos];
                double[] precos = new double[numProdutos];

                for (int i = 0; i < numProdutos; i++) {
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

                try (FileOutputStream fos = new FileOutputStream("produtos_recebidos.dat");
                     DataOutputStream fileOut = new DataOutputStream(fos)) {

                    fileOut.writeInt(numProdutos);

                    for (int i = 0; i < numProdutos; i++) {
                        byte[] nomeBytes = produtos[i].getBytes();
                        fileOut.writeInt(nomeBytes.length); 
                        fileOut.write(nomeBytes); 
                        fileOut.writeDouble(precos[i]);  
                    }

                    System.out.println("Dados salvos no arquivo produtos_recebidos.dat.");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
