import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        boolean jogarNovamente = true;

        while(jogarNovamente) {
            int numMin = 1;
            int numMax;
            int tentmax;
            int dificul;
            int tent = 0;
            boolean acer = false;
            boolean dica = false;

            System.out.println("\nBem-Vindo ao Jogo da Adivinhação!");
            System.out.println("\nEscolha a Dificuldade\n");
            System.out.println("1 - Fácil (Números de 1 a 50, com 10 tentativas)");
            System.out.println("2 - Médio (Números de 1 a 100, com 7 tentativas)");
            System.out.println("3 - Díficil (Números de 1 a 100, com 5 tentativas)");
            System.out.print("\nDigite o Número correspondente à Dificuldade: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um Número válido: ");
                sc.next();
            }

            dificul = sc.nextInt();
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

            int nums = rd.nextInt(numMax) + numMin;

            while (!acer && tent < tentmax) {
                if (tent == 4 && !dica) {
                    dica = true;
                    if (nums % 2 == 0) {
                        System.out.println("\nDica: O Número Secreto é par");
                    } else {
                        System.out.println("\nDica: O Número Secreto é impar");
                    }
                }

                System.out.print("Tentativa " + (tent + 1) + " de " + tentmax + ". Digite um Número: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Por favor, digite um número válido: ");
                    sc.next();
                }

                int palp = sc.nextInt();
                tent++;

                if (palp == nums) {
                    acer = true;
                } else if (palp < nums) {
                    System.out.println("O Número Secreto é maior");
                } else {
                    System.out.println("O Número Secreto é menor");
                }
            }
            if (acer) {
                System.out.println("##################################\nParabéns! Você acertou o Número Secreto " + nums + " com " + tent + " tentativas");
            } else {
                System.out.println("##################################\nVocê exedeu o número de tentativas. O Número Secreto era " + nums);
            }

            System.out.print("Deseja Jogar Novamente? (S/N): ");
            char resp = sc.next().charAt(0);
            jogarNovamente = (resp == 's' || resp == 'S');

        }
        System.out.println("\nObrigado por Jogar!");
        sc.close();
    }
}
