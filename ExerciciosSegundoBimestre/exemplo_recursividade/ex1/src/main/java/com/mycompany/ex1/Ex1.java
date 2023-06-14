/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex1;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Ex1 {

    public static void main(String[] args) {
        int contagem = 0;
        int soma = 0;
        soma(contagem, soma);

    }
    public static void soma(int contagem, int soma){
        if (contagem == 50) {
            JOptionPane.showMessageDialog(null, "Valor do fatorial "+soma);
        } else {
            soma += (contagem+1);
            contagem++;
            soma(contagem, soma);
        }
    }
}
