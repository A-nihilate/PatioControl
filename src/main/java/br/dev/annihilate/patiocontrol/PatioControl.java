package br.dev.annihilate.patiocontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sesi2dia
 */
public class PatioControl {

    static Scanner tecladoTexto = new Scanner(System.in);
    static Scanner tecladoNumero = new Scanner(System.in);

    public static void main(String[] args) {

        List<Veiculo> patio = new ArrayList<>();

        String search;

        int status = -1;
        boolean active = true;

        while (active) {

            System.out.println(" 10) Cadastro \n 11) Listar\n\n 20) Saida veiculo\n 21) Lista Veiculos em Linha\n\n 30) Entrada veiculo\n 31) Lista Veiculos no patio");

            status = tecladoNumero.nextInt();

            switch (status) {

                case 10:
                    cadastro(patio);
                    break;

                case 11:

                    listar(patio, -1);

                    break;

                case 20:

                    search = tecladoTexto.nextLine();
                    statusChange(patio, search, 1);

                    break;

                case 21:

                    listar(patio, 1);
                    break;

                case 30:

                    search = tecladoTexto.nextLine();
                    statusChange(patio, search, 0);

                case 31:

                    listar(patio, 0);
                    break;

                case 99:
                    active = false;
                    break;

                default:
                    System.out.println("invalid try again.");
            }

        }

    }

    public static void cadastro(List<Veiculo> lista) {
        
        

        while (true) {
            
            Veiculo veiculoNovo = new Veiculo();

            System.out.println("Insira a PLACA / Vazio para Cancelar");
            veiculoNovo.placa = tecladoTexto.nextLine();
            if (veiculoNovo.placa.isBlank()) {
                break;
            } else {
                boolean invalid = false;
                for (Veiculo veiculo : lista) {
                    if (veiculo.placa.equals(veiculoNovo.placa)) {
                        System.out.println("Placa Invalida / Já Registrada");
                        invalid = true;
                        break;
                    }
                }
                if (invalid){
                    break;
                }
            }
            System.out.println("Insira a MARCA");
            veiculoNovo.marca = tecladoTexto.nextLine();

            System.out.println("Insira o MODELO");
            veiculoNovo.modelo = tecladoTexto.nextLine();

            lista.add(veiculoNovo);
        }
    }

    public static void listar(List<Veiculo> patio, int searchedStatus) {

        if (patio.isEmpty()) {
            System.out.println("\n\nPatio is Empty\n\n");
        }

        for (Veiculo veiculoAtual : patio) {
            if (veiculoAtual.status == searchedStatus && searchedStatus != -1) {
                System.out.println("=====");
                System.out.println(veiculoAtual.toString());
            } else if (searchedStatus == -1) {
                System.out.println("=====");
                System.out.println(veiculoAtual.toString());

            }
        }
        System.out.println("\nPress Enter to Continue.");
        tecladoTexto.nextLine();

        System.out.println("==========");
    }

    public static void statusChange(List<Veiculo> lista, String search, int operation) {

        for (Veiculo veiculoAtual : lista) {
            if (search.equals(veiculoAtual.placa)) {
                if (veiculoAtual.status != operation) {
                    if (veiculoAtual.status == 0) {
                        System.out.println("Insira o nome do Motorista");
                        veiculoAtual.motorista = tecladoTexto.nextLine();
                        veiculoAtual.changeState();
                    } else {
                        veiculoAtual.motorista = "";
                        veiculoAtual.changeState();
                    }
                    
                } else {
                    System.out.println("Veiculo ja esta em Linha/no patio");
                }
            }
        }
    }
}
