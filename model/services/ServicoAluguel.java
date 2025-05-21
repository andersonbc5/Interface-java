package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

import java.time.Duration;

public class ServicoAluguel {

    private Double precoHora;
    private Double precoDia;

    private ServicoTaxa taxaServicoBrasil;

    public ServicoAluguel(Double precoHora, Double precoDia, ServicoTaxa taxaServicoBrasil) {
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.taxaServicoBrasil = taxaServicoBrasil;
    }

    public void processarFatura(AluguelCarro aluguelCarro){

        double minutos = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).toMinutes();
        double horas = minutos/60.0;

        double pagamentoBasisco;
        if (horas <= 12){
            pagamentoBasisco = precoHora * Math.ceil(horas);
        }
        else {
            pagamentoBasisco = precoDia * Math.ceil(horas/24);
        }

        double taxa = taxaServicoBrasil.taxa(pagamentoBasisco);

        aluguelCarro.setFatura(new Fatura(pagamentoBasisco,taxa));
    }
}
