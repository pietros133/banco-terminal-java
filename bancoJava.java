package projetos;
import java.util.Scanner;

public class bancoJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = -1;
        double userBalance = 0.0;

        while (true) {

            System.out.println("=== BEM VINDO AO YOURBANK ===");
            System.out.println("1 - DEPOSITAR");
            System.out.println("2 - SACAR");
            System.out.println("3 - VER SALDO");
            System.out.println("0 - SAIR");
            System.out.print("Escolha uma opção: ");

            option = sc.nextInt(); 

            switch (option) {

                case 1: {
                    System.out.print("Valor a ser depositado: ");
                    double newValue = sc.nextDouble();

                    if (newValue < 0) {
                        System.out.println("Depósito negado");
                        break;
                    }

                    userBalance += newValue; 
                    System.out.println("DEPÓSITO REALIZADO!");
                    break;
                }

                case 2: {
                    System.out.print("Valor que deseja sacar: ");
                    double sacarValue = sc.nextDouble();

                    if (sacarValue > userBalance) {
                        System.out.println("SAQUE NEGADO! Saldo insuficiente.");
                        break;
                    }

                    if (sacarValue < 5) {
                        System.out.println("SAQUE NEGADO! Valor mínimo é R$5.");
                        break;
                    }

                    userBalance -= sacarValue; 
                    System.out.println("SAQUE REALIZADO!");
                    break;
                }

                case 3: {
                    System.out.println("SALDO ATUAL: R$ " + userBalance);
                    break;
                }

                case 0: {
                    System.out.println("SAINDO...");
                    sc.close();
                    return; 
                }

                default: {
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
                }
            }

            System.out.println();
        }
    }
}
