package funcoes;

//acabei fazendo tudo, foi mal ksks ~matias
//Matias fez tudo e eu modifiquei tudo kkk ~augusto

import java.util.Random;
import java.util.Scanner;

public class Reserva {

    static int[] codigos = new int[100];
    static String[] cpfs = new String[100];
    static int[] numerosQuartos = new int[100];
    static String[] entradasData = new String[100];
    static String[] saidasData = new String[100];
    static String[] nomesReservistas = new String[100];
    static int [] quantidadePessoas = new int[100];
    static int total = 0; // CONTADOR: soma 1 ao contador depois de guardar

    // Pede: CPF do hóspede, número do quarto, data de entrada e data de saída
    // No final imprime o código da reserva

    //vi no CLAUDE pra tirar o aviso do scanner aberto ~matias
    @SuppressWarnings("resource")

    public static void fazerReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== FAZER RESERVA =====");

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

        System.out.println("Digite o nome do reservista: ");
        String nome = scanner.next();

        nomesReservistas[total] = nome;

        System.out.println("Quantidade de pessoas hospedando: ");
        int quantidade = scanner.nextInt();
        
        //Confere se a quantidade de hóspedes não excede a capacidade do quarto ~augusto
        if (quantidade > Cadastrar.capacidades[total]) {
            System.out.println("Quantidade de hóspedes excede capacidade do quarto!");
            return;
        }

        quantidadePessoas[total] = quantidade;

        System.out.print("Data de entrada (dd/mm/aaaa): ");
        String entrada = scanner.next();

        System.out.print("Data de saída (dd/mm/aaaa): ");
        String saida = scanner.next();

        //Transforma a data em ints para poder validar ~augusto
        int dia = Integer.parseInt(entrada.substring(0, 2));
        int mes = Integer.parseInt(entrada.substring(2, 4));
        int ano = Integer.parseInt(entrada.substring(4, 8));

        //Verifica se o ano é bissexto ~augusto
        boolean bissexto = false;

        if (ano % 400 == 0) {
            bissexto = true;
        } else if (ano % 100 == 0) {
            bissexto = false;
        } else if (ano % 4 == 0) {
            bissexto = true;
        }

        //Valida o mês ~augusto
        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido!");
            return;
        }
        
        int limiteDias = 0;

        //Valida o dia de acordo com o mês e se é bissexto ~augusto
        if (mes == 2) {
            
            if (bissexto) {
                limiteDias = 29;
            } else {
                limiteDias = 28;
            }

        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            limiteDias = 30;
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) { 
            limiteDias = 31;
        }

        if (dia < 1 || dia > limiteDias) {
            System.out.println("Dia inválido para o mês informado!");
            return;
        }

        //Valida se a data de entrada e saída não ultrapassam 8 caracteres e formata a data para dd/mm/aaaa ~augusto
        if (entrada.matches("\\d{8}")) {
            entrada = entrada.substring(0, 2) + "/" +
            entrada.substring(2, 4) + "/" +
            entrada.substring(4, 8);
        } else {
            System.out.println("Data de entrada inválida!");
            return;
        }

        if (saida.matches("\\d{8}")) {
            saida = saida.substring(0, 2) + "/" +
            saida.substring(2, 4) + "/" +
            saida.substring(4, 8);
        } else {
            System.out.println("Data de saída inválida!");
            return;
        }

        entradasData[total] = entrada;
        saidasData[total] = saida;

        int codigo = gerarCodigo();

        // Guarda tudo nos vetores ~matias
        codigos[total] = codigo;
        cpfs[total] = cpf;
        numerosQuartos[total] = numeroQuarto;
        entradasData[total] = entrada;
        saidasData[total] = saida;
        nomesReservistas[total] = nome;
        quantidadePessoas[total] = quantidade;

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