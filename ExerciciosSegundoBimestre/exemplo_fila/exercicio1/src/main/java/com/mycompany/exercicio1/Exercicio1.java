/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author gabri
 */
public class Exercicio1 {

    public class FilaPacientes {
        public static void main(String[] args) {
            Queue<String> fila = new LinkedList<>();
            int senhasDisponiveis = 20;
            Scanner scanner = new Scanner(System.in);

            int opcao;
            do {
                System.out.println("Menu:");
                System.out.println("1 - Adicionar paciente");
                System.out.println("2 - Chamar próximo paciente");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        if (senhasDisponiveis > 0) {
                            System.out.print("Digite o nome do paciente: ");
                            String nome = scanner.nextLine();
                            fila.offer(nome);
                            senhasDisponiveis--;
                            System.out.println("Paciente adicionado à fila.");
                        } else {
                            System.out.println("Não há mais senhas disponíveis para consulta.");
                        }
                        break;
                    case 2:
                        if (!fila.isEmpty()) {
                            String proximoPaciente = fila.poll();
                            System.out.println("Próximo paciente: " + proximoPaciente);
                        } else {
                            System.out.println("A fila está vazia.");
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
    }
}
