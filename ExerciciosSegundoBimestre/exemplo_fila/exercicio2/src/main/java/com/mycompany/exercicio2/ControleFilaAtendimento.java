/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author gabri
 */
public class ControleFilaAtendimento {
    private static Queue<Cliente> filaPrioritaria = new LinkedList<>();
    private static Queue<Cliente> filaNormal = new LinkedList<>();
    private static int senhaAtual = 1;
    private static int clientesAtendidos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o ano de nascimento do cliente: ");
                    int anoNascimento = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    Cliente cliente = new Cliente(senhaAtual, nome, anoNascimento);
                    if (isPrioritario(cliente)) {
                        filaPrioritaria.offer(cliente);
                    } else {
                        filaNormal.offer(cliente);
                    }

                    System.out.println("Cliente adicionado à fila. Senha: " + senhaAtual);
                    senhaAtual++;
                    break;

                case 2:
                    Cliente proximoCliente = chamarCliente();
                    if (proximoCliente != null) {
                        System.out.println("Cliente chamado: " + proximoCliente.getNome());
                        clientesAtendidos++;

                        if (clientesAtendidos % 2 == 0) {
                            Cliente clienteNormal = chamarClienteNormal();
                            if (clienteNormal != null) {
                                System.out.println("Cliente normal chamado: " + clienteNormal.getNome());
                            }
                        }
                    } else {
                        System.out.println("Não há clientes na fila.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static boolean isPrioritario(Cliente cliente) {
        int idade = 2023 - cliente.getAnoNascimento();
        return idade >= 65;
    }

    private static Cliente chamarCliente() {
        if (!filaPrioritaria.isEmpty()) {
            return filaPrioritaria.poll();
        } else if (!filaNormal.isEmpty()) {
            return filaNormal.poll();
        } else {
            return null;
        }
    }

    private static Cliente chamarClienteNormal() {
        if (!filaNormal.isEmpty()) {
            return filaNormal.poll();
        } else {
            return null;
        }
    }
}