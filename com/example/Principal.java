package com.example;

import java.util.Scanner;

public class Principal {
    
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
