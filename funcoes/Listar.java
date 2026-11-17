package funcoes;

public class Listar {
    
    public static void listarQuartos() {
        
        // verificar se tem quartos cadastrados ~matias
        if (Cadastrar.totalQuartos == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        // Passa por todos os quartos cadastrados ~matias
        for (int i = 0; i < Cadastrar.totalQuartos; i++) {

            // Procura se existe alguma reserva para esse quarto
            boolean ocupado = false; // começa camo "livre" ~matias
            // continua enquanto j for menor que o número de reservas existentes pra ele não olhar as posições vazias do vetor ~matias
            for (int j = 0; j < Reserva.total ; j++) {
                if (Reserva.numerosQuartos[j] == Cadastrar.numeros[i]) {
                    ocupado = true;
                }
            }

            // Imprime as informações do quarto ~matias
            System.out.println("\nQuarto " + Cadastrar.numeros[i]);
            System.out.println("  Valor: R$ " + Cadastrar.valores[i]);
            System.out.println("  Capacidade: " + Cadastrar.capacidades[i] + " pessoa(s)");

            if (ocupado) {
                System.out.println("  Situação: OCUPADO\n");
            } else {
                System.out.println("  Situação: LIVRE\n");
            }
            System.out.println();
        }
    }
}