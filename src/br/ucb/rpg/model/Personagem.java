package br.ucb.rpg.model;

import br.ucb.rpg.logic.Calculos;

public class Personagem {
    private String nome;
    private int vida;
    private int nivel;
    private int ataque;
    private int defesa;

    public Personagem(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.vida = 100;
        this.ataque = 15;
        this.defesa = 5;
    }

    public int atacar() {
        return Calculos.calcDano(this.ataque, 5);
    }

    public void receberDano(int dano) {
        this.vida -= dano;

        if (this.vida < 0) this.vida = 0;
        System.out.println(this.nome + " agora tem " + this.vida + " de vida.");
    }

    public void evoluir() {
        nivel++;
        vida += 20;
        ataque += 5;
        defesa += 3;
        System.out.println(nome + " subiu de nível! Agora está no nível " + nivel);
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getDefesa() { return defesa; }
}