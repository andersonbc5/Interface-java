package application;


import model.entities.Veiculo;
import model.entities.AluguelCarro;
import model.services.ServicoAluguel;
import model.services.TaxaServicoBrasil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String modelo = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);

        AluguelCarro ac = new AluguelCarro(inicio, fim, new Veiculo(modelo));

        System.out.print("Entre com o preço por hora: ");
        double precoHora = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double precoDia = sc.nextDouble();

        ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora, precoDia, new TaxaServicoBrasil());

        servicoAluguel.processarFatura(ac);

        System.out.println("FATURA: ");
        System.out.println("Pagamento basico: " + String.format("%.2f",ac.getFatura().getPagamentoSimples()));
        System.out.println("Imposto: " + String.format("%.2f",ac.getFatura().getTaxa()));
        System.out.println("Pagamento total: " + String.format("%.2f",ac.getFatura().getpagamentoTotal()));





        sc.close();


    }

}