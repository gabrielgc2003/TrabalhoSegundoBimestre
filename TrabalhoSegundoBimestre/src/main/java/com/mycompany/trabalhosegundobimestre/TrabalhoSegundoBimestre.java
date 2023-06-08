/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalhosegundobimestre;

import com.mycompany.trabalhosegundobimestre.model.ContaBancaria;

import javax.swing.*;

/**
 *
 * @author gabri
 */
public class TrabalhoSegundoBimestre {

    public static void main(String[] args) {
        boolean continua = true;
        int quantidadeContas = Integer.parseInt(JOptionPane.showInputDialog("Quantas contas podem ter seu banco? "));
        int posContaVetor = 0;
        ContaBancaria[] listaContaBancaria = new ContaBancaria[quantidadeContas];
        while(continua) {
            int menu = Integer.parseInt(JOptionPane.showInputDialog("------------MENU------------\n" +
                                                                    "1- Cadastrar conta\n" +
                                                                    "2- Ordenar e Listar\n" +
                                                                    "3- Depositar\n" +
                                                                    "4- Sacar\n" +
                                                                    "5- Total Contas\n" +
                                                                    "6- Verificar Saldos Negativos\n" +
                                                                    "7- Sair"));
            switch (menu) {
                case 1: {
                    //1 - Cadastrando Contas
                    if (posContaVetor == listaContaBancaria.length){
                        JOptionPane.showMessageDialog(null, "Você atingiu o número máximo!");
                    }else {
                        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da " + (posContaVetor + 1) + " ª conta: "));
                        String nomeTitular = JOptionPane.showInputDialog("Digite o titular da  " + (posContaVetor + 1) + "ª conta: ");
                        double saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial da  " + (posContaVetor + 1) + "ª conta: "));
                        listaContaBancaria[posContaVetor] = new ContaBancaria(numeroConta, nomeTitular, saldoConta);
                        posContaVetor++;
                    }
                    break;
                }
                case 2: {
                    //2 - Ordenando a conta passando a lista e a opção
                    if (posContaVetor == 0){
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. " +
                                "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int opcaoOrdenacao = Integer.parseInt(JOptionPane.showInputDialog("Deseja ordenar por número da conta(1) ou saldo(2): "));
                    listaContaBancaria = ordenarConta(listaContaBancaria, opcaoOrdenacao);
                    //2 - Listando a conta
                    listarContas(listaContaBancaria);
                    break;
                }
                case 3: {
                    //3 - Buscando a conta para depósito
                    if (posContaVetor == 0){
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. " +
                                "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int contaBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite uma conta que deseja depositar: "));
                    int posConta = pesquisaConta(listaContaBancaria, contaBusca);

                    if (posConta == -1){
                        JOptionPane.showMessageDialog(null, "Conta ("+contaBusca+") não encontrada.");
                        break;
                    }

                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor que deseja depositar:  "));
                    listaContaBancaria[posConta].deposito(valorDeposito);
                    break;
                }
                case 4:{
                    //4 - Buscando a conta para sacar
                    if (posContaVetor == 0){
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. " +
                                "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int contaBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite uma conta que deseja sacar: "));
                    int posConta = pesquisaConta(listaContaBancaria, contaBusca);

                    if (posConta == -1){
                        JOptionPane.showMessageDialog(null, "Conta ("+contaBusca+") não encontrada.");
                        break;
                    }

                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor que deseja sacar:  "));
                    listaContaBancaria[posConta].saque(valorDeposito);
                    break;
                }
                case 5:{
                    //5 - Calculando o total das contas
                    if (posContaVetor == 0){
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. " +
                                "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int pos = 0;
                    double soma = 0;
                    soma = somaTodasContas(listaContaBancaria, pos, soma);
                    JOptionPane.showMessageDialog(null, "A somatória de todas as contas é de:" + soma);
                    break;
                }
                case 6:{
                    //6 - Verificando saldo negativo
                    if (posContaVetor == 0){
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. " +
                                "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int pos = 0;
                    String contasNegativas = "";
                    contasNegativas = verificaSaldoNegativo(listaContaBancaria, pos, contasNegativas);
                    if (contasNegativas.isEmpty() || contasNegativas.isBlank()){
                        JOptionPane.showMessageDialog(null, "Nenhuma conta tem saldo negativo.");
                    }else {
                        System.out.println(contasNegativas);
                    }
                    break;
                }
                case 7:{
                    continua = false;
                    break;
                }

            }
        }

    }

    public static ContaBancaria[] ordenarConta(ContaBancaria[] listaConta, int opcaoOrdenacao){
        int n = listaConta.length;
        if (opcaoOrdenacao == 1){
            for (int i = 1; i < n ; i++) {
                if(listaConta[i] != null){
                    for (int j = i-1; j < n - i ; j++) {
                        if (listaConta[j + 1] != null) {
                            if (listaConta[j].getNumeroConta() > listaConta[j + 1].getNumeroConta()) {
                                ContaBancaria temp = listaConta[j];
                                listaConta[j] = listaConta[j + 1];
                                listaConta[j + 1] = temp;
                            }
                        }
                    }
                }
            }
        } else if (opcaoOrdenacao == 2) {
            for (int i = 1; i < n ; i++) {
                if(listaConta[i] != null){
                    for (int j = i-1; j < n - i ; j++) {
                        if (listaConta[j + 1] != null) {
                            if (listaConta[j].getSaldo() > listaConta[j + 1].getSaldo()) {
                                ContaBancaria temp = listaConta[j];
                                listaConta[j] = listaConta[j + 1];
                                listaConta[j + 1] = temp;
                            }
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Opção de ordenação não existe!");
            return listaConta;
        }


        return listaConta;
    }

    public static void listarContas(ContaBancaria[] listaConta){

        for (int i = 0; i < listaConta.length ; i++) {
            if (listaConta[i] != null) {
                System.out.println("\nConta: " + listaConta[i].getNumeroConta() +
                        "\nTitular: " + listaConta[i].getNomeTitular() +
                        "\nSaldo: " + listaConta[i].getSaldo() +
                        "\n-----------------------------------------------");
            }
        }

    }

    public static int pesquisaConta(ContaBancaria[] listaConta, int numero) {
        int n = listaConta.length;

        for (int i = 0; i < n; i++){
            if (listaConta[i] != null) {
                if (listaConta[i].getNumeroConta() == numero) {
                    return i;
                }
            }
        }
        return -1;

    }

    public static double somaTodasContas(ContaBancaria[] listaConta, int posicao, double somatoria){
        if (posicao == listaConta.length){
            return somatoria;
        }
        if (listaConta[posicao] != null) {
            somatoria += listaConta[posicao].getSaldo();
            posicao++;
        }else{
            posicao++;
        }
        return somaTodasContas(listaConta, posicao, somatoria);
    }

    public static String verificaSaldoNegativo(ContaBancaria[] listaConta, int posicao, String contasNegativas){
        double aux;
        if (posicao == listaConta.length){
            return contasNegativas;
        }
        if (posicao == 0){
            contasNegativas = "Contas com saldo negativo:";
        }
        if (listaConta[posicao] != null) {
            aux = listaConta[posicao].getSaldo();

            if (aux < 0) {
                contasNegativas += ("\nTitular:" + listaConta[posicao].getNomeTitular() +
                        "/ Conta:" + listaConta[posicao].getNumeroConta() +
                        " / Saldo: " + aux);
            }

            posicao++;
        }else {
            posicao++;
        }
        return verificaSaldoNegativo(listaConta, posicao, contasNegativas);
    }

}
