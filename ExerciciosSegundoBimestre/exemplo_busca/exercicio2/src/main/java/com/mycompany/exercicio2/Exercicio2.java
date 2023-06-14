/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio2;

import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author gabri
 */
public class Exercicio2 {

    public static void main(String[] args) {
        int qtNumero = Integer.parseInt( JOptionPane.showInputDialog("Digite a quantidade de clientes que o vetor vai ter: "));

        Cliente[] vetor = new Cliente[qtNumero];
        
        for(int i = 0; i < vetor.length;i++){
            Cliente cliente = new Cliente();
            cliente.setCodigo(i+1);
            cliente.setCpf( JOptionPane.showInputDialog("Digite o cpf do cliente "+(i+1)+":"));
            cliente.setNome( JOptionPane.showInputDialog("Digite o nome do cliente "+(i+1)+":"));
            cliente.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do cliente " + (i + 1) + ":"));
            vetor[i] = cliente;
        }
        
        //ordenação do vetor
        int chave, j;
        for (int i = 1; i < vetor.length; i++){
            chave = vetor[i].getCodigo();
            for(j = (i-1);  (j >= 0 && vetor[j].getCodigo() > chave); j--){
                vetor[j+1] = vetor[j];
            }
            vetor[j+1].setCodigo(chave);
        }

        int valorBusca = Integer.parseInt(JOptionPane.showInputDialog("Valor de busca: "));
        int resultado = buscaBinaria(vetor, valorBusca);
        if (resultado == -1) {
            System.out.println("O número " + valorBusca + " não foi encontrado no vetor");
        } else {
            System.out.println("O número " + valorBusca + " foi encontrado na posição " + resultado + " do vetor");
            JOptionPane.showMessageDialog(null, "Codigo:" + vetor[resultado].toString());
        }

    }

    public static int buscaBinaria(Cliente[] vetor, int valorBusca) {
        int esquerda = 0;
        int direita = vetor.length - 1;
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            if (vetor[meio].getCodigo() == valorBusca) {
                return meio; // retorna a posição do elemento no vetor
            } else if (vetor[meio].getCodigo() < valorBusca) {
                esquerda = meio + 1;
            } else {
                esquerda = meio - 1;
            }
        }
        return -1; // retorna -1 se o elemento não for encontrado no vetor
    }
}
