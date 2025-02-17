package com.projeto.sd.atv2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.projeto.sd.models.Produto;

public class VendasImpl extends UnicastRemoteObject implements Vendas {


    private static final long serialVersionUID = 1L;
    
    protected VendasImpl() throws RemoteException {
        super();
    }

    @Override
    public String vender(Produto produto, double valor) {

        double valorTotal = produto.getPreco() * produto.getQuantidade();
        double desconto = descontoProduto( valorTotal, produto.getQuantidade());
        valorTotal -= desconto;
        double diferenca = (valorTotal - valor) *-1;

       if(valorTotal > valor) {
            return "\nValor insuficinte.\nFalta: " + diferenca + "\n";
       }else if(valorTotal < valor) {
            return "\nVenda concluida!\nTroco do Cliente: " + diferenca + "\n" ;
       }else {
           return "\nVenda concluida!\n";
       }
    }


    @Override
    public double descontoProduto(double valorTotal, int quantidade) {

        if(quantidade == 2) {
            double desconto = 0.1 * valorTotal;
            System.out.println("\nO cliente vai ter um desconto de 10% Valor desconto: " + desconto);
            return desconto;

        } else if( quantidade > 2 && quantidade < 5 ) {
            double desconto = 0.2 * valorTotal;
            System.out.println("\nO cliente vai ter um desconto de 20% Valor desconto: " + desconto);
            return desconto;

        }else if( quantidade >= 5) {
            double desconto = 0.3 * valorTotal;
            System.out.println("\nO cliente vai ter um desconto de 20% Valor desconto: " + desconto);
            return desconto;
        }

        System.out.println("\nNao tem desconto, quantidade de itens insuficiente.");
        return 0.0;
    }

    @Override
    public String compararPreco(Produto produto1, Produto produto2) {

       if(produto1.getPreco() > produto2.getPreco()) {
        return "\nO " + produto2.getModelo() + " e mais barato\n";
       }
       else if(produto1.getPreco() < produto2.getPreco()) {
        return "\nO " + produto1.getModelo() + " e mais barato\n";
       }

       return "\nOs produtos tem os precos iguais";
    }

    @Override
    public String combos(Produto produto1) {
        if(produto1.getModelo() == "Iphone") {
            return "Sugerir PowerBank, Capa Premium e Pelicula"; 
        }
        else if(produto1.getMarca() == "Samsung") {
            return "Sugerir produtos da mesma marca, pois os usuarios gostam do ecossistema";
        }
        return "Sugerir capa e pelicula para compradores de celular";
    }
}
