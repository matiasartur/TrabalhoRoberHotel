package funcoes;

import java.util.Scanner;

public class Consultar {
    
    @SuppressWarnings("resource")
    // Traz todas as informações guardadas no vetor sobre o quarto ESPECIFICO
    public static void consultarQuarto() {
        Scanner ent = new Scanner(System.in);
        
        System.out.println("===== CONSULTAR QUARTOS =====");

        System.out.println("\nDigite o número do quarto: ");
        int consult = ent.nextInt();
        //Confere se o quarto existe ou não ~augusto
        int posicao = -1;

        for (int i = 0; i < Cadastrar.totalQuartos ; i++) {
            
            if (Cadastrar.numeros[i] == consult) {
                posicao = i;
            }

        }

        if (posicao == -1) {
            System.out.println("\nQuarto não encontrado.");
        
        } else {
            int posicaoReserva = -1;

            for (int i = 0; i < Reserva.total; i++) {

                if (Reserva.numerosQuartos[i] == consult) {
                    posicaoReserva = i;
                    break;
                }
            
            } 
            //Mostra os dados do quarto e da reserva caso exista ~augusto
            if (posicaoReserva != -1) {
                System.out.println("Quarto: " + Cadastrar.numeros[posicao]);
                System.out.println("Valor: " + Cadastrar.valores[posicao]);
                System.out.println("nome do hóspede: " + Reserva.nomesReservistas[posicao]);
                System.out.println("Capacidade: " + Cadastrar.capacidades[posicao]);
                System.out.println("Pessoas hospedando: " + Reserva.quantidadePessoas[posicao]);
                System.out.println("Data de entrada: " + Reserva.entradasData[posicao]);
                System.out.println("Data de saída: " + Reserva.saidasData[posicao]);
                System.out.println("Situação: OCUPADO");
                System.out.println("Código da reserva: " + Reserva.codigos[posicao]);

            } else {
                System.out.println("Quarto: " + Cadastrar.numeros[posicao]);
                System.out.println("Valor: " + Cadastrar.valores[posicao]);
                System.out.println("Capacidade: " + Cadastrar.capacidades[posicao]);
                System.out.println("Situação: LIVRE");

            }

        }

    }
}
