package funcoes;

import java.util.Scanner;

public class Cadastrar {

    //criei vetores para armazenar os dados dos quartos ~matias
    static int[] numeros = new int[100];
    static double[] valores = new double[100];
    static int[] capacidades = new int[100];
    static int totalQuartos = 0; // contador pro vetor não sobrepor ~matias


    @SuppressWarnings("resource") //pesquisei na IA pra tirar o aviso do scanner aberto ~matias

    // Pede: número do quarto, valor do quarto e capacidade de pessoas
    public static void cadastrarQuarto() {
        Scanner scanner = new Scanner(System.in); //não precisa fechar o scanner ~matias

        //verifica se já atingiu o limite de quartos cadastrados ~matias
        if (totalQuartos == 100) {
            System.out.print("Limite de quartos atingido!");
            return;
        }

        System.out.print("\nNúmero do quarto: ");
        int numero = scanner.nextInt();

        //verifica se já existe um quarto com o mesmo número ~matias
        boolean repetido = false;
        for (int i = 0; i < totalQuartos; i++) {
            if (numeros[i] == numero) {
                repetido = true;
            }
        }
        if (repetido) {
            System.out.println("Já existe um quarto com esse número!");
            return;
        }

        System.out.print("Valor do quarto: ");
        double valor = scanner.nextDouble();

        System.out.print("Capacidade de pessoas: ");
        int capacidade = scanner.nextInt();

        numeros[totalQuartos] = numero;
        valores[totalQuartos] = valor;
        capacidades[totalQuartos] = capacidade;

        totalQuartos++;
        System.out.println("Quarto cadastrado com sucesso! \n");
        
    }
    
    //acabei fazendo tudo, desculpa mari ksks ~matias
}
