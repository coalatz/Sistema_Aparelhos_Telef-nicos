package com.projeto.sd.atv2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRmi {

    public static void main(String[] args) {

        try {

            System.out.println("\nServico esta disponivel");

            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);

            VendasImpl vendasImpl = new VendasImpl();
            Naming.bind("rmi://localhost:1099/Vendas", vendasImpl);
            
    
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

