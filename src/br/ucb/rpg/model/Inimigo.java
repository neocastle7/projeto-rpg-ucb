    // Luan:
    // 1. Crie atributos similares ao do Jogador (nome, vida, ataque). [cite: 38]
    // 2. Crie um construtor para definir os status de 3 inimigos diferentes e do Boss.
    // 3. Implemente o sistema de 'premiação' (o que o inimigo solta ao morrer). [cite: 39]

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
        double sorteio = Calculos.gerarChance();
        int dano;

        if (sorteio <= 0.10) {
            System.out.println(nome + " errou o ataque!");
            return;
        }

        dano = Calculos.calcDano(ataqueBase, 2);
        
        if (sorteio >= (1 - chanceCritico )) {
            dano *= 1.5;
            System.out.println("CRÍTICO! " + nome + " causou " + dano + " de dano!");
        }
        
        int danoFinal = dano - alvo.getDefesa();

        if (danoFinal <= 0) {
            danoFinal = 1;
        }

        System.out.println(nome + " causou " + danoFinal + " de dano em " + alvo.getNome());

        alvo.receberDano(danoFinal);
    }

    public void dropItem() {
        double sorteio = Calculos.gerarChance();

        System.out.println("\n--- RECOMPENSA ---");

        if (sorteio <= chanceRaro) {
            System.out.println("SORTE GRANDE! Voce encontrou um item raro: " + itemRaro);
        } else {
            System.out.println("Voce encontrou um item comum: " + itemComum);
        }
    }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public String getNome() { return nome; }

}

// Inimigo Goblin = new Inimigo("Goblin Sorrateiro", 30, 8, 5, "itemComum", "itemRaro", 0.15, 0.05);
        
// Inimigo inimigo02 = new Inimigo("Golem de Pedra", 100, 12, 15, "itemComum", "itemRaro", 0.10, 0.02);
        
// Inimigo inimigo03 = new Inimigo("Assasino das Sombras", 20, 25, 7, "itemComum", "itemRaro", 0.05, 0.30);

// Inimigo boss = new Inimigo("General Morto-Vivo", 300, 15, 10, "itemComum", "itemRaro", 1.0, 0.15);