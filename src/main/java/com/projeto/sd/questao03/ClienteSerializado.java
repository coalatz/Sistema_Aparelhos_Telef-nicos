package com.projeto.sd.questao03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.projeto.sd.models.Capa;
import com.projeto.sd.models.Celular;
import com.projeto.sd.models.Pelicula;
import com.projeto.sd.models.Produto;

public class ClienteSerializado {
    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 12354)) {
            List<Produto> produtos = new ArrayList<>();
            produtos.add(new Celular("iPhone 12", 59.99f, 1, "Apple", 512, 8, "IOS"));
            produtos.add(new Capa("Capa Silicone", 59.99f, 1, "Gcase", "Iphone 12", "Silicone"));
            produtos.add(new Pelicula("Pelicula Vidro", 39.99f, 1, "Vidros", "Iphone 12", "Vidro"));
        
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(produtos);
            System.out.println("Lista de produtos enviadas");

             ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
             String resposta = (String) objectIn.readObject();

             System.out.println("Resposta do servidor: " + resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
