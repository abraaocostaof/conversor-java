package com.example.conversormoedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonResponse = ApiService.getExchangeRates();
            CurrencyConverter converter = new CurrencyConverter(jsonResponse);

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("Bem-vindo ao Conversor de Moedas!");

            while (running) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Converter USD para outra moeda");
                System.out.println("2. Converter outra moeda para USD");
                System.out.println("3. Sair");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Digite a moeda de destino (ex: BRL): ");
                        String toCurrency = scanner.next().toUpperCase();
                        System.out.print("Digite o valor em USD: ");
                        double amount = scanner.nextDouble();

                        double result = converter.convert("USD", toCurrency, amount);
                        System.out.printf("Resultado: %.2f %s%n", result, toCurrency);
                        break;

                    case 2:
                        System.out.print("Digite a moeda de origem (ex: BRL): ");
                        String fromCurrency = scanner.next().toUpperCase();
                        System.out.print("Digite o valor em " + fromCurrency + ": ");
                        amount = scanner.nextDouble();

                        result = converter.convert(fromCurrency, "USD", amount);
                        System.out.printf("Resultado: %.2f USD%n", result);
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        running = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
