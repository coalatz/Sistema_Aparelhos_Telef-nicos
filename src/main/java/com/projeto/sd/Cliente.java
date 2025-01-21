package com.projeto.sd;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.projeto.sd.models.Capa;
import com.projeto.sd.models.Celular;
import com.projeto.sd.models.Pelicula;
import com.projeto.sd.models.Produto;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Conectado ao servidor.");

            Produto[] produtos = {
                new Celular("iPhone 12", 59.99f, 1, "Apple", 512, 8, "IOS"),
                new Capa("Capa Silicone", 59.99f, 1, "Gcase", "Iphone 12", "Silicone"),
                new Pelicula("Pelicula Vidro", 39.99f, 1, "Vidros", "Iphone 12", "Vidro"),
                new Capa("PowerBank Anker", 199.99f, 1, "Apple", "Iphone 12", "Silicone")
            };

            try (DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream())) {
                dataOut.writeInt(produtos.length);

                for (Produto produto : produtos) {
                    byte[] nomeBytes = produto.getModelo().getBytes();
                    dataOut.writeInt(nomeBytes.length);  
                    dataOut.write(nomeBytes);  
                    dataOut.writeDouble(produto.getPreco());  
                }

                System.out.println("Dados enviados para o servidor.");
            }

            
            try (FileOutputStream fos = new FileOutputStream("produtos.dat");
                 DataOutputStream fileOut = new DataOutputStream(fos)) {

                
                fileOut.writeInt(produtos.length);

                // Salvar os produtos no arquivo
                for (Produto produto : produtos) {
                    byte[] nomeBytes = produto.getModelo().getBytes();
                    fileOut.writeInt(nomeBytes.length);
                    fileOut.write(nomeBytes);  
                    fileOut.writeDouble(produto.getPreco());  
                }

                System.out.println("Dados salvos no arquivo produtos.dat.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
