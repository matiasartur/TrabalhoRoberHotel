package principal;

import java.util.Scanner;

import funcoes.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar quarto");
            System.out.println("2 - Fazer reserva");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Listar quartos");
            System.out.println("5 - Consultar quarto");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Cadastrar.cadastrarQuarto();
                    break;
                case 2:
                    Reserva.fazerReserva();
                    break;
                case 3:
                    Cancelar.cancelarReserva();
                    break;
                case 4:
                    Listar.listarQuartos();
                    break;
                case 5:
                    Consultar.consultarQuarto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

}

