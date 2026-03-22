package br.ucb.rpg.model;

    // Jennyfer:
    // 1. Declare aqui os atributos: nome (String), vida, nivel, ataque e defesa (int). [cite: 23]
    // 2. Crie um metodo chamado 'atacar' que retorne o valor do dano. [cite: 26]
    // 3. Crie um metodo chamado 'receberDano' que diminua a vida do jogador. [cite: 27]
    // 4. Crie a lógica de 'evoluir' para aumentar os atributos quando subir de nível. [cite: 24, 28]

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
        this.ataque = 10;
        this.defesa = 5;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVida() {
        return this.vida;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getDefesa() {
        return this.defesa;
    }

    // Método para mostrar status
    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
    }
 
    // método para mostrar seu nível atual
    public void evoluir() {
        nivel++;
        vida += 20;
        ataque += 5;
        defesa += 3;

        System.out.println(nome + " subiu de nível!");
        System.out.println("Agora está no nível " + nivel);
    }

    // Atacar outro personagem
    public void atacar(Personagem inimigo) {
        int dano = this.ataque - inimigo.getDefesa();

        if (dano <= 0) {
            dano = 1; // garante dano mínimo
        }

        System.out.println(this.nome + " atacou " + inimigo.getNome() + " causando " + dano + " de dano!");

        inimigo.receberDano(dano);
    }

    // Receber dano do combate 
    public void receberDano(int dano) {
        this.vida -= dano;

        if (this.vida < 0) {
            this.vida = 0;
        }

        System.out.println(this.nome + " agora tem " + this.vida + " de vida.");

        if (this.vida == 0) {
            System.out.println(this.nome + " foi derrotado!");
        }
    }
}
