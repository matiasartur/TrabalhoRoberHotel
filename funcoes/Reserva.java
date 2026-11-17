package funcoes;

//acabei fazendo tudo, foi mal ksks ~matias

import java.util.Random;
import java.util.Scanner;

public class Reserva {

    static int[] codigos = new int[100];
    static String[] cpfs = new String[100];
    static int[] numerosQuartos = new int[100];
    static String[] entradasData = new String[100];
    static String[] saidasData = new String[100];
    static int total = 0; // CONTADOR: soma 1 ao contador depois de guardar

    // Pede: CPF do hóspede, número do quarto, data de entrada e data de saída
    // No final imprime o código da reserva

    //vi no CLAUDE pra tirar o aviso do scanner aberto ~matias
    @SuppressWarnings("resource")

    public static void fazerReserva() {
        Scanner scanner = new Scanner(System.in);

        // Confere se ainda cabe mais uma reserva ~matias
        if (total == 100) {
            System.out.println("\nLimite de reservas atingido!");
            return;
        }

        System.out.print("\nCPF do hóspede (11 números): ");
        String cpf = scanner.next();

        //formatação do cpf ~matias
        if (!cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido! Digite 11 números.");
            return;
        }

        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        // Confere se o quarto já está cadastrado ~matias
        boolean existe = false;
        for (int i = 0; i < Cadastrar.totalQuartos; i++) {
            if (Cadastrar.numeros[i] == numeroQuarto) {
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("Quarto não cadastrado!");
            return;
        }

        // Confere se o quarto já está reservado ~matias
        for (int i = 0; i < total; i++) {
            if (numerosQuartos[i] == numeroQuarto) {
                System.out.println("Esse quarto já está reservado!");
                return;
            }
        }

        System.out.print("Data de entrada (dd/mm/aaaa): ");
        String entrada = scanner.next();

        System.out.print("Data de saída (dd/mm/aaaa): ");
        String saida = scanner.next();

        int codigo = gerarCodigo();

        // Guarda tudo nos vetores ~matias
        codigos[total] = codigo;
        cpfs[total] = cpf;
        numerosQuartos[total] = numeroQuarto;
        entradasData[total] = entrada;
        saidasData[total] = saida;

        System.out.println("\nCódigo da reserva: " + codigo);
        total++;
    }

    //fiz pra poder fazer minha parte, gera o código de reserva ~ matias
    public static int gerarCodigo() {
        Random sorteio = new Random();
        int codigo;
        boolean repetido;

        do {
            codigo = sorteio.nextInt(900000) + 100000;

            repetido = false;
            for (int i = 0; i < total; i++) {
                if (codigos[i] == codigo) {
                    repetido = true;
                }
            }
        } while (repetido);

        return codigo;
    }
}