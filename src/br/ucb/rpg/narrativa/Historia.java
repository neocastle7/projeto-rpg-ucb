package br.ucb.rpg.narrativa;

public class Historia {

    public static void introducao() {
        System.out.println("\n==================================================");
        System.out.println("          RPG: O DESPERTAR DA NATUREZA            ");
        System.out.println("==================================================");
        System.out.println("O mundo está murchando. A Grande Floresta está sendo");
        System.out.println("asfixiada pela poluição de uma antiga forja mecânica.");
        System.out.println("Você foi escolhido para purificar as fontes de água");
        System.out.println("e deter o avanço da destruição ambiental.");
        System.out.println("Sua jornada começa agora. O ar está pesado, mas a");
        System.out.println("natureza clama por um protetor...");
        System.out.println("--------------------------------------------------\n");
    }

    public static void falaInimigo(String nomeInimigo) {
        System.out.println("\n[" + nomeInimigo + " brada]:");

        switch (nomeInimigo) {
            case "Goblin Sorrateiro":
                System.out.println("- 'Ria enquanto pode! O lixo que jogamos no rio nos deu forças!'");
                break;
            case "Golem de Pedra":
                System.out.println("- 'Eu sou a montanha que vocês tentaram minerar sem piedade!'");
                break;
            case "Assasino das Sombras":
                System.out.println("- 'A escuridão da fumaça das fábricas é o meu lar!'");
                break;
            case "General Morto-Vivo":
                System.out.println("- 'A natureza é fraca! O progresso de metal e ossos é eterno!'");
                break;
            default:
                System.out.println("- 'Você não passará por aqui!'");
                break;
        }
        System.out.println("--------------------------------------------------");
    }

    public static void desfecho() {
        System.out.println("\n==================================================");
        System.out.println("                VITÓRIA ECOLÓGICA                 ");
        System.out.println("==================================================");
        System.out.println("Com a queda do General, as máquinas pararam.");
        System.out.println("As águas voltaram a ser cristalinas e a floresta");
        System.out.println("voltou a respirar. A acessibilidade à vida foi");
        System.out.println("restaurada para todos os seres do reino.");
        System.out.println("Parabéns, Herói! Você salvou o Meio Ambiente.");
        System.out.println("==================================================\n");
    }
}