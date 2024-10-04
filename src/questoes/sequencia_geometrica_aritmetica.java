package questoes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class sequencia_geometrica_aritmetica {
    private String tipo; 
    private int primeiroTermo;
    private double razao; 

    public sequencia_geometrica_aritmetica(String tipo, int primeiroTermo, double razao) {
        this.tipo = tipo.toLowerCase(); 
        this.primeiroTermo = primeiroTermo;
        this.razao = razao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toLowerCase();
    }

    public int getPrimeiroTermo() {
        return primeiroTermo;
    }

    public void setPrimeiroTermo(int primeiroTermo) {
        this.primeiroTermo = primeiroTermo;
    }

    public double getRazao() {
        return razao;
    }

    public void setRazao(double razao) {
        this.razao = razao;
    }

    public void imprimeProgressao(int n) {
        if (!tipo.equals("aritmetica") && !tipo.equals("geometrica")) {
            System.out.println("\nTipo de sequência inválido. Você precisa escrever, por extenso, 'aritmetica' ou 'geometrica'.");
            return;
        }

        for (int i = 0; i < n; i++) {
            double termoAtual;
            if (tipo.equals("aritmetica")) {
                termoAtual = primeiroTermo + (razao * i);
            } else { 
                termoAtual = primeiroTermo * Math.pow(razao, i);
            }

            System.out.print(termoAtual + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;

            while (continuar) {
                String tipo = "";
                int primeiroTermo = 0;
                double razao = 0;
                int n = 0;

                try {
                    System.out.print("\nEscreva por extenso o tipo da sequência (aritmetica/geometrica): ");
                    tipo = scanner.next();

                    System.out.print("\nDigite o primeiro termo da sequência: ");
                    primeiroTermo = scanner.nextInt();

                    System.out.print("\nDigite a razão da sequência: ");
                    razao = scanner.nextDouble();

                    System.out.print("\nQuantos termos deseja imprimir na sequência? ");
                    n = scanner.nextInt();

                    if (n <= 0) {
                        System.out.println("\nO número de termos deve ser maior que zero.");
                    } else {
                        sequencia_geometrica_aritmetica sequencia = new sequencia_geometrica_aritmetica(tipo, primeiroTermo, razao);
                        System.out.print("\nSequência: " + tipo + " \n");
                        sequencia.imprimeProgressao(n);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nEntrada inválida. Por favor, insira um número válido.");
                    scanner.next(); 
                }

                while (true) {
                    System.out.println("\nDeseja realizar outra sequência?" );
                    System.out.println("\n1 - Sim \n2 - Não");
                    System.out.print("\nVocê escolheu: ");
                    String resposta = scanner.next();

                    if (resposta.equals("1")) {
                        continuar = true;
                        break; 
                    } else if (resposta.equals("2")) {
                        continuar = false;
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\n5\n");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\n4\n");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\n3\n");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\n2\n");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\n1\n");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\nO programa se encerrou!.");
                        System.exit(0);
                        break; 
                    } else {
                        System.out.println("\nResposta inválida! Por favor, digite '1' para sim ou '2' para não.");
                    }
                }
            }
        }

        System.out.println("\nPrograma encerrado.");
    }
}
