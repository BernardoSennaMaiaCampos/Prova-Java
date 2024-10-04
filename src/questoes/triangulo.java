package questoes;

import java.util.Scanner;

public class triangulo {
    private int A;
    private int B;
    private int C;

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }

    public void calcularTriangulo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o valor de a: ");
            int a = scanner.nextInt();
            System.out.print("Digite o valor de b: ");
            int b = scanner.nextInt();
            System.out.print("Digite o valor de c: ");
            int c = scanner.nextInt();

            setA(a);
            setB(b);
            setC(c);

            
            if (!isTriangulo(a, b, c)) {
                System.out.println("\nNão é um triângulo. Deseja tentar novamente?");
                System.out.println("\n1 - Sim \n2 - Não");
                System.out.print("\nVocê escolheu: ");
                int resposta = scanner.nextInt();

                if (resposta == 2) {
                    System.out.println("\nCálculo encerrado.");
                    break; 
                }
            } else {
                System.out.println("\nÉ um triângulo, seu perímetro é: " + (a + b + c));
                System.out.println("\nTipo: " + verificarTipo(a, b, c));
                System.out.println("\nDeseja continuar o programa?");
                System.out.println("\n1 - Sim \n2 - Não");
                System.out.print("\nVocê escolheu: ");
                int resposta = scanner.nextInt();

                if (resposta == 2) {
                    System.out.println("\nCálculo encerrado.");
                    break; 
                }
            }
        }
        scanner.close(); 
    }
            
            
    private boolean isTriangulo(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    private String verificarTipo(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || b == c || a == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public static void main(String[] args) {
        triangulo triangulo = new triangulo();
        triangulo.calcularTriangulo();
    }
}




