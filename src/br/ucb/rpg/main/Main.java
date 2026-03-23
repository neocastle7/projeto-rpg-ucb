package br.ucb.rpg.main;

import br.ucb.rpg.model.*;
import br.ucb.rpg.logic.*;
import br.ucb.rpg.narrativa.Historia;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Narrativa do Leonardo
        Historia.introducao();

        System.out.print("Digite o nome do seu Herói: ");
        String nomeHeroi = teclado.nextLine();

        // 2. Esperando Jogador da Jennyfer (Vai dar erro até ela commitar)
        // Jogador player = new Jogador(nomeHeroi);

        // 3. Inimigos do Luan
        Inimigo[] horda = {
                new Inimigo("Goblin Sorrateiro", 30, 8, 5, "Lixo", "Cristal", 0.15, 0.05),
                new Inimigo("Golem de Pedra", 100, 12, 15, "Pedra", "Núcleo", 0.10, 0.02),
                new Inimigo("General Morto-Vivo", 300, 15, 10, "Ossos", "Coração", 1.0, 0.15)
        };

        for (Inimigo atual : horda) {
            Historia.falaInimigo(atual.getNome());
            int turnoEspecial = 0;

            // Simulando a vida do player enquanto a Jennyfer não termina
            int playerVidaSimulada = 100;

            while (atual.getVida() > 0 && playerVidaSimulada > 0) {
                if (atual.getNome().contains("General")) {
                    Cenario.desenharBoss(atual.getVida(), playerVidaSimulada);
                } else {
                    Cenario.desenharBatalha(atual.getNome(), atual.getVida(), playerVidaSimulada);
                }

                System.out.println("\nMENU: [1] Atacar | [2] Especial (Carga: " + turnoEspecial + "/2)");
                int acao = teclado.nextInt();

                if (acao == 1) {
                    // 4. Lógica de Dano do Jackson
                    int dano = Calculos.calcDano(15, 5);
                    atual.setVida(atual.getVida() - dano);
                    System.out.println("Você causou " + dano + " de dano!");
                    turnoEspecial++;
                }

                // Turno do Inimigo (Simulado)
                playerVidaSimulada -= 10;
            }
        }

        Historia.desfecho();
    }
}