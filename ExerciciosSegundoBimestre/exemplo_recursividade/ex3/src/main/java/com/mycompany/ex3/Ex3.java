/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex3;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Ex3 {

    public static void main(String[] args) {
        int numero = 0;
        int contador = 5;
        String msg = "";
        calcularFibonacci(numero, contador, msg);
        
    }
    
    public static void calcularFibonacci(int n, int contador, String msg) {
        if (n <= 1 || contador == 0) {
            if(contador == 0){
                JOptionPane.showMessageDialog(null, "Sequencia de Fibonnaci:" + msg);
            }
            msg += n + " ";
            n++;
            contador--;
            calcularFibonacci(n, contador, msg);
        } else {
            msg += ((n-1)+(n-2)) + " ";
            n++;
            contador--;
            calcularFibonacci(n, contador, msg);
        }

        
    }

}
