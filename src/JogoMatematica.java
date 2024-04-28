import java.util.Random;
import java.util.Scanner;

public class JogoMatematica {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random random = new Random();

        int num1 = 0; int num2 = 1; int num3;

        int resp; int repete;
        int pontuacao = 0;

        boolean intervalo = true;

        System.out.println("--- Bem-Vindo ao Jogo de Matemática ---");

        while (true) {

            System.out.println("""
                
                Escolha qual tipo de cálculo você quer fazer:
                
                1 - Cálculos básicos (adição e subtração)
                2 - Cálculo intermediário (multiplicação e divisão)
                3 - Desafio (cálculos maiores de adição e subtração)
                """);
            int escolha = ler.nextInt();

            System.out.print("Digite quantos cálculos você deseja realizar (1 a 10): ");
            repete = ler.nextInt();

            switch (escolha) {
                case 1: // Cálculo básico de adição e subtração

                    for (int i = 0; i < repete; i++) {
                        // Gera dois números aleatórios onde o primeiro não pode ser menor que o segundo
                        while (num1 < num2) {
                            num1 = random.nextInt(100) + 1;
                            num2 = random.nextInt(100) + 1;
                        }

                        // Faz com que as contas de adição e subtração apareçam intervaladamente
                        if (intervalo) {
                            System.out.println("Quanto é " + num1 + " + " + num2 + " ?");
                        } else {
                            System.out.println("Quanto é " + num1 + " - " + num2 + " ?");
                        }
                        resp = ler.nextInt();

                        // De acordo com o intervalo mostra se a resposta está ou não correta
                        if (intervalo) {
                            // Verifica se a resposta da adição está correta
                            if (resp == num1 + num2) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                            System.out.println("Você errou, a resposta certa era: " + (num1 + num2));
                            }
                            // Verifica se a resposta da subtração está correta
                        } else {
                            if (resp == num1 - num2) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                                System.out.println("Você errou, a resposta certa era: " + (num1 - num2));
                            }
                        }
                        intervalo = i % 2 != 0;
                        num1 = 0; num2 = 1;
                    }
                    break;
                case 2: // Cálculo intermediário de multiplicação e divisão

                    for (int i = 0; i < repete; i++) {
                        while (num1 < num2) {
                            num1 = random.nextInt(10) + 1;
                            num2 = random.nextInt(10) + 1;
                        }

                        if (intervalo) {
                            System.out.println("Quanto é " + num1 + " * " + num2 + " ?");
                        } else {
                            System.out.println("Quanto é " + num1 + " / " + num2 + " ?");
                        }
                        resp = ler.nextInt();

                        if (intervalo) {
                            if (resp == num1 * num2) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                                System.out.println("Você errou, a resposta certa era: " + (num1 * num2));
                            }
                        } else {
                            if (resp == num1 / num2) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                                System.out.println("Você errou, a resposta certa era: " + (num1 / num2));
                            }
                        }

                        intervalo = i % 2 != 0;
                        num1 = 0; num2 = 1;
                    }
                    break;
                case 3:

                    for (int i = 0; i < repete; i++) {
                        // Gera três números aleatórios onde o primeiro não pode ser menor que o segundo
                        num1 = random.nextInt(100) + 1;
                        num2 = random.nextInt(num1) + 1;
                        num3 = random.nextInt(100) + 1;

                        // Faz com que as contas de adição e subtração apareçam intervaladamente
                        if (intervalo) {
                            System.out.println("Quanto é " + num1 + " + " + num2 + " + " + num3 + " ?");
                        } else {
                            System.out.println("Quanto é " + num1 + " - " + num2 + " + " + num3 + " ?");
                        }
                        resp = ler.nextInt();

                        // De acordo com o intervalo mostra se a resposta está ou não correta
                        if (intervalo) {
                            // Verifica se a resposta da adição está correta
                            if (resp == num1 + num2 + num3) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                                System.out.println("Você errou, a resposta certa era: " + (num1 + num2 + num3));
                            }
                            // Verifica se a resposta da subtração está correta
                        } else {
                            if (resp == num1 - num2 + num3) {
                                System.out.println("Parabéns você acertou!");
                                pontuacao++;
                            } else {
                                System.out.println("Você errou, a resposta certa era: " + (num1 - num2 + num3));
                            }
                        }
                        intervalo = i % 2 != 0;
                    }
                    break;
                default:
                    System.out.println("Digite um número válido!");
            }
            // Pergunta se o usuário quer jogar novamente
            System.out.print("Deseja Jogar Novamente? (S/N): ");
            char jogarNovamente = ler.next().charAt(0);
            if (jogarNovamente == 's' || jogarNovamente == 'S') continue;
            break;
        }
        System.out.println("\nVocê acertou " + pontuacao + " cálculos!");
        ler.close();
    }
}