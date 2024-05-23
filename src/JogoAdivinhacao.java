import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    static Scanner ler = new Scanner(System.in);
    static Random rd = new Random();

    static int[] score = {0, 0, 0};
    static int numMax;
    static int tentMax;

    public static void main(String[] args) {
        boolean jogarNovamente = true;
        final int numMin = 1;

        System.out.println("\nBem-Vindo ao Jogo da Adivinhação!");

        while (jogarNovamente) {
            boolean dica = false;
            boolean win = false;
            int tent = 1;

            choseDificult();
            int numS = rd.nextInt(numMax) + numMin;

            while (!win && tent <= tentMax) {
                if (tent == 5 && !dica) {
                    dica = true;
                    if (numS % 2 == 0) {
                        System.out.println("\nDica: O Número Secreto é par");
                    } else {
                        System.out.println("\nDica: O Número Secreto é impar");
                    }
                }

                System.out.print("Tentativa " + tent + " de " + tentMax + ". Digite um Número: ");
                int palp = ler.nextInt();

                if (palp == numS) {
                    win = true;
                } else if (palp < numS) {
                    System.out.println("O Número Secreto é maior");
                } else {
                    System.out.println("O Número Secreto é menor");
                }
                tent++;
            }

            if (win) {
                score[0] += (numMax - tent + 1) * 10;
                score[1]++;
                System.out.println("##################################");
                System.out.println("Parabéns! Você acertou o Número Secreto " + numS + " com " + (tent - 1) + " tentativas");
            } else {
                score[2]++;
                System.out.println("##################################");
                System.out.println("Você exedeu o número de tentativas. O Número Secreto era " + numS);
            }
            System.out.println("Pontuação: " + score[0] + " vitórias: " + score[1] + " derrotas: " + score[2]);

            System.out.print("Deseja Jogar Novamente? (S/N): ");
            char resp = ler.next().charAt(0);
            jogarNovamente = (resp == 's' || resp == 'S');
        }

        System.out.println("\nPontuação final: " + score[0] + "\nvitórias: " + score[1] + "\nderrotas: " + score[2]);
        System.out.println("\nObrigado por Jogar!");
        ler.close();
    }

    public static void choseDificult() {
        int dificul;

        while (true) {
            System.out.println("\nEscolha a Dificuldade\n");
            System.out.println("1 - Fácil (Números de 1 a 50, com 10 tentativas)");
            System.out.println("2 - Médio (Números de 1 a 100, com 7 tentativas)");
            System.out.println("3 - Díficil (Números de 1 a 100, com 5 tentativas)");
            System.out.print("\nDigite o Número correspondente à Dificuldade: ");

            dificul = ler.nextInt();
            switch (dificul) {
                case 1:
                    numMax = 50;
                    tentMax = 10;
                    break;
                case 2:
                    numMax = 100;
                    tentMax = 7;
                    break;
                case 3:
                    numMax = 100;
                    tentMax = 5;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente");
                    continue;
            }
            break;
        }
    }
}