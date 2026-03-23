package br.ucb.rpg.model;

import br.ucb.rpg.logic.Calculos;

public class Inimigo {
    private String nome;
    private int vida;
    private int ataqueBase;
    private int defesa;
    private String itemComum;
    private String itemRaro;
    private double chanceRaro;
    private double chanceCritico;

    public Inimigo(String nome, int vida, int ataqueBase, int defesa, String itemComum, String itemRaro, double chanceRaro, double chanceCritico) {
        this.nome = nome;
        this.vida = vida;
        this.ataqueBase = ataqueBase;
        this.defesa = defesa;
        this.itemComum = itemComum;
        this.itemRaro = itemRaro;
        this.chanceRaro = chanceRaro;
        this.chanceCritico = chanceCritico;
    }

    public void atacar(Personagem alvo) {
        int dado = (int) (Calculos.gerarChance() * 100);
        int danoFinal = 0;

        if (dado <= 10) {
            System.out.println(nome + " errou o ataque!");
        } else if (dado > (100 - (chanceCritico * 100))) {
            danoFinal = (int) (ataqueBase * 1.5);
            System.out.println("💥 CRÍTICO! " + nome + " causou " + danoFinal + " de dano!");
        } else {
            danoFinal = Calculos.calcDano(ataqueBase, 2);
            System.out.println(nome + " atacou e causou " + danoFinal + " de dano.");
        }
        alvo.receberDano(danoFinal);
    }

    public void dropItem() {
        double sorteio = Calculos.gerarChance();
        System.out.println("\n--- 🎁 RECOMPENSA DE " + nome.toUpperCase() + " ---");
        if (sorteio <= chanceRaro) {
            System.out.println("🏆 SORTE GRANDE! Você encontrou um item raro: " + itemRaro);
        } else {
            System.out.println("📦 Você encontrou um item comum: " + itemComum);
        }
    }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public String getNome() { return nome; }
}