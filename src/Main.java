import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Escaneia os Números do Usuario
        Scanner sc =  new Scanner(System.in);
        System.out.print("Digite o Primeiro Número: ");
        double num1 = sc.nextDouble();
        System.out.print("Digite o Segundo Número: ");
        double num2 = sc.nextDouble();
        System.out.print("Digite o Terceiro Número: ");
        double num3 = sc.nextDouble();

        // Faz a média dos números
        double med = (num1 + num2 + num3) / 3;

        // Deixa com apenas duas casa decimais
        DecimalFormat df = new DecimalFormat("#.##");
        String medfor = df.format(med);

        // Transforma a virgula em ponto para o programa entender
        String medforp = String.valueOf(medfor).replace(',','.');

        // Transforma a String em double para o programa entender
        double medf = Double.parseDouble(medforp);

        // Mostra se o Número é par ou impar
        if (medf % 2 == 0) {
            System.out.println("A Media do Número é " + medf + " e ele é par\n");
        } else {
            System.out.println("A Media do Número é " + medf + " e ele é impar\n");
        }

        // Proximo Número
        System.out.println("Digite um Número: ");
        int num4 = sc.nextInt();

        // Informa se o Número é Positivo ou Negativo
        if (num4 > 0) {
            System.out.println("O Número " + num4 + " é positivo");
        } else if (num4 > 0) {
            System.out.println("O Número " + num4 + " é negativo");
        } else {
            System.out.println("O Número é zero :|");
        }

        sc.close();
    }
}