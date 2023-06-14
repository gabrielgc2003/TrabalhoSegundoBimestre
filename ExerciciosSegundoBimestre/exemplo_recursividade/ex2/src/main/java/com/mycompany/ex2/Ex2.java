/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex2;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Ex2 {

    public static void main(String[] args) {
        int vlCalculado = 1;
        int valor = 5;
        
        calculaFatorial(valor, vlCalculado);
    }
    
    public static void calculaFatorial(int valor, int vlCalculado){
        
        if(valor == 0 || valor == 1){
            JOptionPane.showMessageDialog(null, "Valor do fatorial "+vlCalculado);
        }else{
            vlCalculado += vlCalculado * (valor - 1);
            valor--;
            calculaFatorial(valor, vlCalculado);
        }
        
    }
}
