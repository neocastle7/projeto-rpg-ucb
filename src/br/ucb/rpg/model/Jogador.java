package br.ucb.rpg.model;

    // Jennyfer:
    // 1. Declare aqui os atributos: nome (String), vida, nivel, ataque e defesa (int). [cite: 23]
    // 2. Crie um metodo chamado 'atacar' que retorne o valor do dano. [cite: 26]
    // 3. Crie um metodo chamado 'receberDano' que diminua a vida do jogador. [cite: 27]
    // 4. Crie a lógica de 'evoluir' para aumentar os atributos quando subir de nível. [cite: 24, 28]


class Personagem {

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

    // status,(menu) do jogador.
    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
    }

    // Método principal, Sempre que o jogador vencer um combate: evolui um nível.
    public void evoluir() {
        nivel++;
        vida += 20;
        ataque += 5;
        defesa += 3;

        System.out.println(nome + " subiu de nível!");
        System.out.println("Agora está no nível " + nivel);
    }
}

