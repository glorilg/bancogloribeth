package com.example;

import java.util.Scanner;

public class BancSimple {
    private static String[] nombres = { "Juan Pérez", "María González", "Carlos López" };
    private static double[] saldos = { 1500.00, 800.00, 1200.00 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int indiceDeposito = seleccionarCuenta(scanner);
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    depositar(indiceDeposito, montoDeposito);
                    break;

                case 2:
                    int indiceRetiro = seleccionarCuenta(scanner);
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    retirar(indiceRetiro, montoRetiro);
                    break;

                case 3:
                    int indiceConsulta = seleccionarCuenta(scanner);
                    consultarSaldo(indiceConsulta);
                    break;

                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void menu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("----------------");
    }

    public static int seleccionarCuenta(Scanner scanner) {
        System.out.println("Seleccione la cuenta:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println((i + 1) + ". " + nombres[i]);
        }
        System.out.print("Ingrese el número de la cuenta: ");
        int seleccion = scanner.nextInt();
        return seleccion - 1; // Devolver índice de cuenta
    }

    public static void depositar(int indice, double monto) {
        if (indice >= 0 && indice < saldos.length) {
            saldos[indice] += monto;
            System.out.println("Depósito realizado. Nuevo saldo: $" + saldos[indice]);
        } else {
            System.out.println("Índice de cuenta no válido.");
        }
    }

    public static void retirar(int indice, double monto) {
        if (indice >= 0 && indice < saldos.length) {
            if (saldos[indice] >= monto) {
                saldos[indice] -= monto;
                System.out.println("Retiro realizado. Nuevo saldo: $" + saldos[indice]);
            } else {
                System.out.println("Fondos insuficientes.");
            }
        } else {
            System.out.println("Índice de cuenta no válido.");
        }
    }

    public static void consultarSaldo(int indice) {
        if (indice >= 0 && indice < saldos.length) {
            System.out.println("Saldo de " + nombres[indice] + ": $" + saldos[indice]);
        } else {
            System.out.println("Error: saldo insuficiente para realizar el retiro.");
        }
    }
       
    }