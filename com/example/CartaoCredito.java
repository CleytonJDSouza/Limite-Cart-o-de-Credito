package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CartaoCredito {
    private double limite;
    private double saldo;
    private List<Compra> compras;
    
    public CartaoCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this. compras = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return new ArrayList<>(compras);
    }

    public void realizarCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a descrição da compra: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o valor da compra: ");
        double valor = scanner.nextDouble();

        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            Compra novaCompra = new Compra(descricao, valor);
            compras.add(novaCompra);
            saldo -= valor;
            System.out.println("Compra realizada!");
        }
    }

    public void exibirCompras() {
        for (Compra compra : compras) {
            System.out.println(compra);
        }
    }

    public void exixbirResumo(){
        System.out.println("\n=======================");
        System.out.println("RESUMO DAS COMPRAS");
        System.out.println("=======================");

        for (Compra compra : compras) {
            System.out.println(compra.getDescricao() + " = " + compra.getValor());
        }

        System.out.println("=======================");
        System.out.println("Saldo do cartão: " + saldo);
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();

        CartaoCredito cartao = new CartaoCredito(limite);

        int opcao;
        do {
            System.out.println("Digite 0 para sair ou 1 para continuar");
            opcao = scanner.nextInt();

            if(opcao == 1) {
                cartao.realizarCompra();
            }
        } while (opcao != 0);

        System.out.println("COMPRAS REALIZADAS:");
        cartao.exixbirResumo();
    }
}
