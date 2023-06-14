/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Exercicio1 {

    public static void main(String[] args) {
        int qtNumero = Integer.parseInt( JOptionPane.showInputDialog("Digite a quantidade de valores que o vetor vai ter: "));
        
        int []vetor = new int[qtNumero];
        
        for(int i = 0; i < vetor.length;i++){
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da posição "+(i+1)+":"));
        }
        
        //ordenação do vetor
        int chave, j;
        for (int i = 1; i < vetor.length; i++){
            chave = vetor[i];
            for(j = (i-1);  (j >= 0 && vetor[j] > chave); j--){
                vetor[j+1] = vetor[j];
            }
            vetor[j+1] = chave;
        }
        
        //metodo de busca
        int metodoBusca = Integer.parseInt(JOptionPane.showInputDialog("Método de Busca: 1 - Linear / 2 - Binária : "));
        
        
        if (metodoBusca == 1){ //Método Linear
            int valorBusca = Integer.parseInt(JOptionPane.showInputDialog("Valor de busca: "));
            int resultado = buscaLinear(vetor, valorBusca);
            if (resultado == -1) {
                System.out.println("O número " + valorBusca + " não foi encontrado no vetor");
            } else {
                System.out.println("O número " + valorBusca + " foi encontrado na posição " + resultado + " do vetor");
            } 
        }
        else if (metodoBusca == 2){ //Método Binário
            int valorBusca = Integer.parseInt(JOptionPane.showInputDialog("Valor de busca: "));
            int resultado = buscaBinaria(vetor, valorBusca);
            if (resultado == -1) {
                System.out.println("O número " + valorBusca + " não foi encontrado no vetor");
            } else {
                System.out.println("O número " + valorBusca + " foi encontrado na posição " + resultado + " do vetor");
            } 
        
        }else{
            JOptionPane.showMessageDialog(null, "Selecionou uma opção inválida.");
            System.exit(metodoBusca);
        }
        
    }
    public static int buscaLinear(int[] vetor, int valorBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorBusca) {
                return i; // retorna a posição do elemento no vetor
            }
        }
        return -1; // retorna -1 se o elemento não for encontrado no vetor
    }
    
    public static int buscaBinaria(int[] vetor, int valorBusca) {
        int esquerda = 0;
        int direita = vetor.length - 1;
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            if (vetor[meio] == valorBusca) {
                return meio; // retorna a posição do elemento no vetor
            } else if (vetor[meio] < valorBusca) {
                esquerda = meio + 1;
            } else {
                esquerda = meio - 1;
            }
        }
        return -1; // retorna -1 se o elemento não for encontrado no vetor
    }
}
