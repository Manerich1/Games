import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    static Scanner ler = new Scanner(System.in);
    static Random rd = new Random();

    static int numMax;
    static int tentmax;

    public static void main(String[] args) {
        boolean jogarNovamente = true;
        final int numMin = 1;
        int tent = 1;
        boolean win = false;
        boolean dica = false;

        System.out.println("\nBem-Vindo ao Jogo da Adivinhação!");

        while (jogarNovamente) {
            choseDificult();

            // Gera de acordo com a escolha de dificuldade, o número secreto que terá de ser descoberto
            int nums = rd.nextInt(numMax) + numMin;

            // Se ainda não foi acertado o número secreto e as tentativas ainda estão abaixo do máximo de tentativas o jogo continua
            while (!win && tent <= tentmax) {
                // Se foram feitas 4 tentativas e a dica ainda não foi dada, será informada um dica
                if (tent == 5 && !dica) {
                    dica = true;
                    // Verifica se o número secreto é par ou ímpar e dá a dica de acordo com o cálculo
                    if (nums % 2 == 0) {
                        System.out.println("\nDica: O Número Secreto é par");
                    } else {
                        System.out.println("\nDica: O Número Secreto é impar");
                    }
                }

                System.out.print("Tentativa " + tent + " de " + tentmax + ". Digite um Número: ");

                int palp = ler.nextInt();
                tent++;

                // Verifica se o usuário acertou o número secreto
                if (palp == nums) {
                    win = true;
                } else if (palp < nums) { // Se o usuário errou, vai ser informado se o palpite dele é menor ou maior que o número secreto
                    System.out.println("O Número Secreto é maior");
                } else {
                    System.out.println("O Número Secreto é menor");
                }
            }

            // Verifica se o usuário acertou ou excedeu o número de tentativas e informa se ouve vitória ou derrota
            if (win) {
                System.out.println("##################################\nParabéns! Você acertou o Número Secreto " + nums + " com " + tent + " tentativas");
            } else {
                System.out.println("##################################\nVocê exedeu o número de tentativas. O Número Secreto era " + nums);
            }

            // Pergunta se o usuário quer jogar novamente
            System.out.print("Deseja Jogar Novamente? (S/N): ");
            char resp = ler.next().charAt(0);
            jogarNovamente = (resp == 's' || resp == 'S');

        }
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

            // De acordo com a dificuldade escolhida, muda as váriaveis de número máximo e tentativas máximas
            dificul = ler.nextInt();
            switch (dificul) {
                case 1:
                    numMax = 50;
                    tentmax = 10;
                    break;
                case 2:
                    numMax = 100;
                    tentmax = 7;
                    break;
                case 3:
                    numMax = 100;
                    tentmax = 5;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente");
                    continue;
            }
            break;
        }
    }
}