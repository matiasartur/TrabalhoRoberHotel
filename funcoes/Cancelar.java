package funcoes;

import java.util.Scanner;

public class Cancelar {


    @SuppressWarnings("resource")
     public static void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o código da reserva: ");
        int codigo = scanner.nextInt();

        int posicao = -1;
        for (int i = 0; i < Reserva.total; i++) {
            if (Reserva.codigos[i] == codigo) {
                posicao = i;
            }
        }

        if (posicao == -1) {
            System.out.println("Reserva não encontrada.");
        } else {
            for (int i = posicao; i < Reserva.total - 1; i++) {
                Reserva.codigos[i] = Reserva.codigos[i + 1];
                Reserva.cpfs[i] = Reserva.cpfs[i + 1];
                Reserva.numerosQuartos[i] = Reserva.numerosQuartos[i + 1];
                Reserva.entradasData[i] = Reserva.entradasData[i + 1];
                Reserva.saidasData[i] = Reserva.saidasData[i + 1];
            }

            Reserva.total--;

            System.out.println("\nReserva cancelada com sucesso!");
        }
    }
}