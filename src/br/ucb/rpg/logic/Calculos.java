package br.ucb.rpg.logic;

import java.util.Random;
//importa a classe Random, para gerar numeros aleatorios

public class Calculos {

    // Cria um gerador de números aleatórios
    private static Random random = new Random();

    // Metodo responsável por calcular o dano e retorna um valor inteiro
    public static int calcDano(int ataqueBase, int variacao){
        //ataqueBase = valor do ataque 10
        //ex  de variacao = 2

        // Define o valor minimo do dano
        //garante que o dano minimo nao seja negativo
        //ataqueBase = valor do ataque 10
        //ex  de variacao = 2
        //minimo = 10- 2 (8)
        int minimo = Math.max(0, ataqueBase - variacao);

        // Define o valor maximo do dano

        int maximo = ataqueBase + variacao;

        // (maximo - minimo + 1) define o tamanho do intervalo
        //ex: ataque(10) = (12 - 8 + 1) = 5
        //nextInt() - gera numero de 0 ate limite-1 (5-1)
        // Soma o valor mínimo para que o número aleatório comece a partir dele
        // EX: 0 + 8 = 8, comeca apartir de 8 e vai ate (4+min) 12
        //ele escolhe um valor aleatorio entre "8 e 12"

        int dano = random.nextInt(maximo - minimo + 1) + minimo;

        // Retorna o valor final do dano
        return dano;
    }

}