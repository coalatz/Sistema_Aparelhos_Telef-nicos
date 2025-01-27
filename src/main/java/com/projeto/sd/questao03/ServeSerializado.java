package com.projeto.sd.questao03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.projeto.sd.models.Produto;

public class ServeSerializado {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(12354)) {
            System.out.println("Servidor agurdando conexao...");
        
                try(Socket socket = serverSocket.accept()) {
                    System.out.println("Conexao recebida.");
                
                    ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());

                    List<Produto> produtos = (List<Produto>) entrada.readObject();
                    System.out.println("Produtos recebidos: " + produtos);

                    String resposta = "Produtos processados" + produtos;
                    
                    saida.writeObject(resposta);
                    System.out.println("Resposta enviado para o cliente");

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
