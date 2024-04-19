import java.util.Arrays;
import java.util.Scanner;

public class JogoVelha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        char[][] tabuleiro = new char[3][3];
        char jogadorAtual = 'X';
        boolean jogoAcabou = false;

        // Cria o tabuleiro totalmente vazio
        for (char[] espacos : tabuleiro) {
            Arrays.fill(espacos, ' ');
        }

        while (!jogoAcabou) {

            // Exibe o tabuleiro totalmente vazio com as cordenadas das linhas e colunas
            System.out.println("  1 2 3"); // cordenadas das colunas
            for (int i = 0; i < 3; i++) {
                System.out.print((i + 1) + " "); // cordenadas das linhas
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            // Pede pro jogador fazer uma jogada e registra em qual posição ela fica
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada (linha coluna): ");
            int linha = ler.nextInt() - 1;
            int coluna = ler.nextInt() - 1;

            // Verifica se a posição está vazia
            if (tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;
            } else {
                System.out.println("Posição já ocupada! Tente novamente");
                continue;
            }

            // Verifica se houve uma vitória
            for (int i = 0; i < tabuleiro.length; i++) {
                if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual ||
                        tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAcabou = true;
                }
            }
            if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual ||
                    tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                jogoAcabou = true;
            }

            // Verifica se houve empate
            boolean empate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == ' ') {
                        empate = false;
                        break;
                    }
                }
            }
            if (empate) {
                System.out.println("O jogo empatou!");
                jogoAcabou = true;
            }

            // Alterna o jogador
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        ler.close();
    }
}
