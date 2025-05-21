package model.entities;

public class Fatura {

    private Double pagamentoSimples;
    private Double taxa;

    public Fatura(){

    }

    public Fatura(Double pagamentoSimples, Double taxa) {
        this.pagamentoSimples = pagamentoSimples;
        this.taxa = taxa;
    }

    public Double getPagamentoSimples() {
        return pagamentoSimples;
    }

    public void setPagamentoSimples(Double pagamentoSimples) {
        this.pagamentoSimples = pagamentoSimples;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double getpagamentoTotal() {
        return getPagamentoSimples() + getTaxa();
    }
}
