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

    private static final String[] PERGUNTAS_VF = {
            "Brasília é a capital do Brasil. (Verdadeiro ou Falso)",
            "O Sol é uma estrela. (Verdadeiro ou Falso)",
            "O alfabeto tem 27 letras. (Verdadeiro ou Falso)",
            "A Terra é plana. (Verdadeiro ou Falso)"
    };
    private static final boolean[] RESPOSTAS_VF = {true, true, false, false};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int pont = 0;

        System.out.println("\nBem-Vindo ao Jogo de Quiz!");
        System.out.println("Responda as perguntas corretamente para ganhar pontos");

        boolean[] pergf = new boolean[PERGUNTAS_ME.length + PERGUNTAS_VF.length];

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

        for (int i = 0; i < PERGUNTAS_VF.length; i++) {
            int indp;
            do {
                indp = rd.nextInt(PERGUNTAS_VF.length);
            } while (pergf[PERGUNTAS_ME.length + indp]);

            pergf[PERGUNTAS_ME.length + indp] = true;

            System.out.println("\nPergunta " + (i + 1 + PERGUNTAS_ME.length) + ":");
            System.out.println(PERGUNTAS_VF[indp]);
            System.out.println("\nSua resposta (Verdadeiro [V] ou Falso [F]): ");
            String resp = sc.nextLine().toUpperCase();

            boolean respB = resp.equals("V") || resp.equals("F") ? false : false;

            if (respB == RESPOSTAS_VF[indp]) {
                System.out.println("Resposta correta! Você ganhou 10 pontos");
                pont += 10;
            } else {
                System.out.println("Resposta incorreta. A resposta certa é: " + (RESPOSTAS_VF[indp - PERGUNTAS_ME.length] ? "Verdadeiro" : "Falso"));
            }
        }

        System.out.println("\nFim de Jogo!");
        System.out.println("Sua pontuação final: " + pont);

        sc.close();
    }
}