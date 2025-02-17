package com.projeto.sd.atv2;

import java.rmi.Naming;
import java.util.Scanner;

import com.projeto.sd.models.Celular;

public class ClienteRmi {

    public static void main(String[] args) {
        try {
            Vendas vendas = (Vendas) Naming.lookup("rmi://localhost:1099/Vendas");
            Scanner scanner = new Scanner(System.in);
            int opcao = 0;

            while (opcao != 5) {
                System.out.println("\nMenu:");
                System.out.println("1. Vender Produto");
                System.out.println("2. Calcular Desconto");
                System.out.println("3. Comparar precos");
                System.out.println("4. Sugestao de combos");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
            
            
            switch (opcao) {
                case 1: 
                Celular celular = new Celular("iPhone 12", 2500.0f, 1, "Apple", 512, 8, "IOS");
                System.out.println(vendas.vender(celular, 3000)); 
                break;

                case 2: 
                System.out.println(vendas.descontoProduto(5000, 2)); 
                break;

                case 3: 
                Celular celular2 = new Celular("Galaxy s23", 1500.0f, 1, "Samsumg", 512, 8, "Android");
                Celular celular3 = new Celular("Moto Z5", 3500.0f, 1, "Motorola", 512, 8, "Android");
                System.out.println( vendas.compararPreco(celular3, celular2));
                break;

                case 4:
                Celular celular5 = new Celular("iPhone", 2500.0f, 1, "Apple", 512, 8, "IOS");
                System.out.println( vendas.combos(celular5));
                break;
            }

        }

              
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
