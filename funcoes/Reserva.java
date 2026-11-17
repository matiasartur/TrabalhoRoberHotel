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

        // Confere se o quarto já está cadastrado e guarda a posição dele ~matias
        boolean existe = false;
        int posicaoQuarto = -1;
        for (int i = 0; i < Cadastrar.totalQuartos; i++) {
            if (Cadastrar.numeros[i] == numeroQuarto) {
                existe = true;
                posicaoQuarto = i;
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

        scanner.nextLine(); // limpa o "Enter" que sobrou do nextint ~matias

        // aceita nome e sobrenome ~matias
        String nome = "";
        while (nome.trim().isEmpty()) {
            System.out.print("Digite o nome do reservista: ");
            nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("O nome não pode ficar vazio!");
            }
        }

        System.out.print("Quantidade de pessoas hospedando: ");
        int quantidade = scanner.nextInt();

        //Confere se a quantidade de hóspedes não excede a capacidade do quarto ~augusto
        if (quantidade > Cadastrar.capacidades[posicaoQuarto]) {
            System.out.println("Quantidade de hóspedes excede capacidade do quarto!");
            return;
        }

        System.out.print("Data de entrada (dd/mm/aaaa): ");
        String entrada = scanner.next();
        if (!dataValida(entrada)) {
            System.out.println("Data de entrada inválida! Use o formato dd/mm/aaaa.");
            return;
        }

        System.out.print("Data de saída (dd/mm/aaaa): ");
        String saida = scanner.next();
        if (!dataValida(saida)) {
            System.out.println("Data de saída inválida! Use o formato dd/mm/aaaa.");
            return;
        }

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

    // Confere se a data está no formato dd/mm/aaaa e se ela existe de verdade ~augusto
    public static boolean dataValida(String data) {

        // Precisa ser: 2 números / 2 números / 4 números
        if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        // Separa dia, mês e ano (pulando as barras nas posições 2 e 5)
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));

        if (mes < 1 || mes > 12) {
            return false;
        }

        //Verifica se o ano é bissexto ~augusto
        boolean bissexto = false;
        if (ano % 400 == 0) {
            bissexto = true;
        } else if (ano % 100 == 0) {
            bissexto = false;
        } else if (ano % 4 == 0) {
            bissexto = true;
        }

        // Define quantos dias o mês tem
        int limiteDias;
        if (mes == 2) {
            if (bissexto) {
                limiteDias = 29;
            } else {
                limiteDias = 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            limiteDias = 30;
        } else {
            limiteDias = 31;
        }

        return dia >= 1 && dia <= limiteDias;
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