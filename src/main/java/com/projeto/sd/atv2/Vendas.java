package com.projeto.sd.atv2;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.projeto.sd.models.Produto;

public interface Vendas extends Remote {
    
    public String vender(Produto produto, double valor) throws RemoteException;
    public double descontoProduto(double valorTotal, int quantidade)  throws RemoteException;
    public String compararPreco(Produto produto1, Produto produto2)  throws RemoteException;
    public String combos(Produto produto1) throws RemoteException;
    
}
