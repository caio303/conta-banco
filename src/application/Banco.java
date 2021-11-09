package application;

import entities.ContaBancaria;

import java.util.Scanner;

import static entities.ContaBancaria.saldoDeposito;
import static entities.ContaBancaria.saldoSaque;

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o nome do titular: ");
        String nome = sc.nextLine();
        System.out.print("Insira o numero da conta: ");
        int conta = sc.nextInt();
        System.out.print("Haverá um depósito inicial?(s/n)");
        char resposta = sc.next().charAt(0);

        ContaBancaria c1;
        if (resposta == 's' || resposta == 'S') {
            System.out.print("Insira o valor do depósito inicial: ");
            double depositoInicial = sc.nextDouble();
            c1 = new ContaBancaria(nome, conta, depositoInicial);
            System.out.println();
            System.out.println("Dados da conta: ");
            System.out.println(c1);
        } else if (resposta == 'n' || resposta == 'N') {
            c1 = new ContaBancaria(nome, conta);
            System.out.println();
            System.out.println("Dados da conta: ");
            System.out.println(c1);
        } else {
            System.out.println("Resposta invalida...");
            c1 = new ContaBancaria(nome, conta);
            System.out.println();
            System.out.println("Dados da conta: ");
            System.out.println(c1);
        }
        int menu;
        do {
            System.out.println("\nMENU: 1-DADOS DA CONTA | 2-DEPOSITO | 3-SAQUE | 4-CONFIGURACOES | 5-SAIR");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Dados da conta: ");
                    System.out.println(c1);
                    break;
                case 2:
                    saldoDeposito(c1);
                    break;
                case 3:
                    saldoSaque(c1);
                    break;
                case 4:
                    System.out.println("1-MUDAR NOME DO TITULAR | 2-VOLTAR");
                    int menu2 = sc.nextInt();
                    sc.nextLine();
                    if (menu2 == 1) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = sc.nextLine();
                        c1.setName(novoNome);
                        System.out.println("Nome do titular alterado com sucesso...");
                    } else {
                        System.out.println("Voltando...");
                    }
                    break;
                case 5:{
                    break;
                }
                default:
                    System.out.println("Resposta invalida...");
                    break;
            }

        } while (menu != 5);

        System.out.println("Obrigado pela preferência!");


        sc.close();
    }
}
