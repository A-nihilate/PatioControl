package br.dev.annihilate.patiocontrol;

/**
 * Classe dos Veiculos
 *
 * @author Annihilate
 */
public class Veiculo {

    String placa;
    String modelo;
    String marca;
    String motorista = "";
    int status = 0;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo, String marca, String motorista) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.motorista = motorista;
    }

    public void changeState() {
        if (this.status == 1) {
            status = 0;
        } else {
            status = 1;
        }
    }

    @Override
    public String toString() {
        return String.format("\n=====\n| Placa | Modelo | Marca | Motorista | Status |\n|%7s|%8s|%7s|%11s|%8s|\n=====", this.placa, this.modelo, this.marca, this.motorista, this.status);

    }

}
