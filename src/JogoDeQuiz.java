import java.util.Random;
import java.util.Scanner;

public class JogoDeQuiz {
    private static final String[] PERGUNTAS_ME = {
            "Qual é a capital do Brasil?\n(A) Rio de Janeiro\n(B) São Paulo\n(C) Brasília\n",
            "Qual é a cor do céu em um dia ensolarado?\n(A) Amarelo\n(B) Azul\n(C) Vermelho\n",
            "Quem escreveu 'Dom Quixote'?\n(A) Machado de Assis\n(B) Wiliam Shakespear\n(C) Miguel de Cervantes\n",
            "Qual é o maior planeta do nosso sistema solar?\n(A) Júpiter\n(B) Terra\n(C) Marte\n"
    };
    private static final String[] RESPOSTAS_ME = {"C", "B", "C", "A"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int pont = 0;

        System.out.println("\nBem-Vindo ao Jogo de Quiz!");
        System.out.println("Responda as perguntas corretamente para ganhar pontos");

        boolean[] pergf = new boolean[PERGUNTAS_ME.length];

        for (int i = 0; i < PERGUNTAS_ME.length; i++) {
            int indp;
            do {
                indp = rd.nextInt(PERGUNTAS_ME.length);
            } while (pergf[indp]);

            pergf[indp] = true;

            System.out.println("\nPergunta " + (i + 1) + ": " + PERGUNTAS_ME[indp]);
            System.out.println("Sua resposta: ");
            String resp = sc.nextLine().toUpperCase();

            if (resp.equals(RESPOSTAS_ME[indp])) {
                System.out.println("Resposta correta! Você ganhou 10 pontos");
                pont += 10;
            } else {
                System.out.println("Resposta incorreta. A resposta certa é: " + RESPOSTAS_ME[indp]);
            }
        }

        System.out.println("\nFim de Jogo!");
        System.out.println("Sua pontuação final: " + pont);

        sc.close();
    }
}
