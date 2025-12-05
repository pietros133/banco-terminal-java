package projetos;

import java.util.concurrent.ThreadLocalRandom;

public class validaProcesso {

    public static void main(String[] args) {
      
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO",
                               "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        
        selecionarAteCincoCandidatosPorSalarioPretendido(candidatos);
    }

   
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    
    static void selecionarCandidatoPorSalarioPretendido(String candidato) {
        double salarioBase = 2000.0;
        double salarioPretendido = valorPretendido();

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O(A) CANDIDATO(A) " + candidato);
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O(A) CANDIDATO(A) " + candidato + ", COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

   
    static void selecionarAteCincoCandidatosPorSalarioPretendido(String[] candidatos) {
        double salarioBase = 2000.0;
        int candidatosSelecionados = 0;

        for (String candidato : candidatos) {
            double salarioPretendido = valorPretendido();
            if (salarioBase >= salarioPretendido && candidatosSelecionados < 5) {
                candidatosSelecionados++;
                tentarLigarParaCandidato(candidato);
            }
        }
    }

    
    static boolean atendeu() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    
    static void tentarLigarParaCandidato(String candidato) {
        int tentativas = 0;

        while (tentativas < 3) {
            tentativas++;
            if (atendeu()) {
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " APÓS " + tentativas + " TENTATIVAS");
                break;
            } else if (tentativas == 3) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O(A) CANDIDATO(A) " + candidato);
            }
        }
    }
}
