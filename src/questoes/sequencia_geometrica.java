package questoes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class sequencia_geometrica {

    private int primeiroTermo; 
    private int razao; 

    public sequencia_geometrica(int primeiroTermo, int razao) {
        this.primeiroTermo = primeiroTermo;
        this.razao = razao;
    }

    public int getPrimeiroTermo() {
        return primeiroTermo;
    }

    public void setPrimeiroTermo(int primeiroTermo) {
        this.primeiroTermo = primeiroTermo;
    }

    public int getRazao() {
        return razao;
    }

    public void setRazao(int razao) {
        this.razao = razao;
    }

    public void imprimeProgressao(int n) {
        for (int i = 0; i < n; i++) {
            double termoAtual = primeiroTermo * Math.pow(razao, i); 
            System.out.print(termoAtual + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; 

        while (continuar) {
            int primeiroTermo = 0;
            int razao = 0;
            int n = 0;

            try {
                System.out.print("\nDigite o primeiro termo da sequência geométrica: ");
                primeiroTermo = scanner.nextInt();

                System.out.print("\nDigite a razão da sequência geométrica: ");
                razao = scanner.nextInt();

                System.out.print("\nQuantos termos deseja imprimir na sequência? ");
                n = scanner.nextInt();

                if (n <= 0) {
                    System.out.println("\nO número de termos deve ser maior que zero.");
                } else {
                    sequencia_geometrica sequenciaGeometrica = new sequencia_geometrica(primeiroTermo, razao);
                    System.out.print("\nSequência geométrica: ");
                    sequenciaGeometrica.imprimeProgressao(n);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); 
            }

            
            while (true) {
                System.out.println("\nDeseja realizar outra sequência geométrica?" );
                System.out.println("\n1 - Sim \n2 - Não");
                System.out.print("\nVocê escolheu: ");
                String resposta = scanner.next();

                if (resposta.equals("1")) {
                    continuar = true;
                    break; 
                } else if (resposta.equals("2")) {
                    continuar = false;
                    System.out.println("\nObrigado! Até a próxima.");
                    break; 
                } else {
                    System.out.println("\nResposta inválida! Por favor, digite '1' para sim ou '2' para não.");
                }
            }
        }

        scanner.close();
        System.out.println("\nPrograma encerrado.");
    }
}
