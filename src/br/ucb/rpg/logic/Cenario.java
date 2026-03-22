package br.ucb.rpg.logic;

public class Cenario {

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void desenharBatalha(String nomeInimigo, int hpInimigo, int hpJogador) {
        limparTela();
        System.out.println("====================================================================================================");
        System.out.println("  👤 HERÓI: [HP " + hpJogador + "]                                     👾 INIMIGO: " + nomeInimigo + " [HP " + hpInimigo + "]");
        System.out.println("====================================================================================================");

        if (nomeInimigo.equals("Goblin Sorrateiro")) {
            System.out.println("        ( )                                     _  _              ");
            System.out.println("        /|\\                                   ( `  ' )            ");
            System.out.println("       / | \\             V S                 (  o  o  )           ");
            System.out.println("      /  |  \\                                 \\  --  /            ");
            System.out.println("         |                                    / ---- \\            ");
            System.out.println("        / \\                                  /  |  |  \\           ");
        } else if (nomeInimigo.equals("Golem de Pedra")) {
            System.out.println("        ( )                                  ________________     ");
            System.out.println("        /|\\                                 |  _      _      |    ");
            System.out.println("       / | \\             V S                | [0]    [0]     |    ");
            System.out.println("      /  |  \\                               |       __       |    ");
            System.out.println("         |                                  |______|  |______|    ");
            System.out.println("        / \\                                 |      |__|      |    ");
        } else {
            // Desenho padrão para outros inimigos (Assassino)
            System.out.println("        ( )                                       /\\              ");
            System.out.println("        /|\\                                      /  \\             ");
            System.out.println("       / | \\             V S                    | >  < |          ");
            System.out.println("      /  |  \\                                    \\ -- /           ");
            System.out.println("         |                                      --|  |--          ");
            System.out.println("        / \\                                      /    \\           ");
        }

        System.out.println("____________________________________________________________________________________________________");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void desenharBoss(int hpBoss, int hpJogador) {
        limparTela();
        System.out.println("====================================================================================================");
        System.out.println("  🔥 CONFRONTO FINAL: " + hpJogador + " HP vs BOSS: " + hpBoss + " HP 🔥");
        System.out.println("====================================================================================================");
        System.out.println("                                             ________________________               ");
        System.out.println("        ( )                                 /                        \\              ");
        System.out.println("        /|\\                                |    🔥  (O)    (O)  🔥    |             ");
        System.out.println("       / | \\                               |            V             |             ");
        System.out.println("      /  |  \\                               \\________________________/              ");
        System.out.println("         |                                  /          |  |          \\             ");
        System.out.println("        / \\                                /           |  |           \\            ");
        System.out.println("####################################################################################################");
    }
}