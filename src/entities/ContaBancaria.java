package entities;

import java.util.Scanner;

import static java.lang.String.format;

public class ContaBancaria {
    private static Scanner sc = new Scanner(System.in);
    private String name;
    private int conta;
    private double saldo;

    //CONSTRUCTORS
    public ContaBancaria(String name, int conta, double saldo) {
        this.name = name;
        this.conta = conta;
        this.saldo = saldo;
    }

    public ContaBancaria(String name, int conta) {
        this.name = name;
        this.conta = conta;
    }

    // |----ContaBancaria METHODS---|
    public static void saldoDeposito(ContaBancaria obj) {
        System.out.print("Insira um valor para depositar: ");
        double deposito = sc.nextDouble();
        if (deposito > 0) {
            obj.saldo += deposito;
            System.out.println("Dados atualizados: ");
        } else {
            System.out.println("Valor invalido...");
        }
        System.out.println(obj);
    }

    public static void saldoSaque(ContaBancaria obj) {
        System.out.print("Insira um valor para sacar: ");
        double saque = sc.nextDouble();
        if (saque > 0) {
            obj.saldo -= saque + 2/* Taxa de 2 reais cobrada ao realizar saques */;
            System.out.println("Dados atualizados: ");
        } else {
            System.out.println("Valor invalido...");
        }
        System.out.println(obj);
    }

    // GETTERS ------------------------
    public String getName() {
        return this.name;
    }

    // SETTERS ------------------------
    public void setName(String name) {
        this.name = name;
    }

    public int getConta() {
        return this.conta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // TO STRING ---------------------
    public String toString() {
        return "Numero: "
                + this.conta
                + ", Titular: "
                + this.name
                + ", Saldo: R$"
                + format("%.2f", this.saldo);
    }

}
