package br.ucb.rpg.main;

import br.ucb.rpg.model.*;
import br.ucb.rpg.logic.*;
import br.ucb.rpg.narrativa.Historia;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Historia.introducao();

        System.out.print("Digite o nome do seu Herói: ");
        String nomeHeroi = teclado.nextLine();

        Personagem player = new Personagem(nomeHeroi);

        Inimigo[] horda = {
                new Inimigo("Goblin Sorrateiro", 30, 8, 5, "Lixo", "Cristal", 0.15, 0.05),
                new Inimigo("Golem de Pedra", 100, 12, 15, "Pedra", "Núcleo", 0.10, 0.02),
                new Inimigo("General Morto-Vivo", 300, 15, 10, "Ossos", "Coração", 1.0, 0.15)
        };

        for (Inimigo atual : horda) {
            Historia.falaInimigo(atual.getNome());
            int turnoEspecial = 0;

            while (atual.getVida() > 0 && player.getVida() > 0) {
                if (atual.getNome().contains("General")) {
                    Cenario.desenharBoss(atual.getVida(), player.getVida());
                } else {
                    Cenario.desenharBatalha(atual.getNome(), atual.getVida(), player.getVida());
                }

                System.out.println("\nMENU: [1] Atacar | [2] Especial (Carga: " + turnoEspecial + "/2)");
                int acao = teclado.nextInt();
                teclado.nextLine();

                if (acao == 2 && turnoEspecial >= 2) {
                    int danoEsp = player.atacar() * 2;
                    atual.setVida(atual.getVida() - danoEsp);
                    System.out.println("✨ ESPECIAL! Você causou " + danoEsp + " de dano!");
                    turnoEspecial = 0;
                } else {
                    int dano = player.atacar();
                    atual.setVida(atual.getVida() - dano);
                    System.out.println("⚔️ Você causou " + dano + " de dano!");
                    if (turnoEspecial < 2) turnoEspecial++;
                }

                if (atual.getVida() > 0) {
                    System.out.println("\nTURNO DO INIMIGO...");
                    atual.atacar(player);
                    System.out.println("Pressione Enter para continuar...");
                    teclado.nextLine();
                }
            }

            if (player.getVida() <= 0) {
                System.out.println("\n💀 FIM DE JOGO! A natureza sucumbiu...");
                return;
            } else {
                System.out.println("\n✅ " + atual.getNome() + " derrotado!");
                atual.dropItem();
                player.evoluir();
                System.out.println("Pressione Enter para seguir adiante...");
                teclado.nextLine();
            }
        }

        Historia.desfecho();
    }
}