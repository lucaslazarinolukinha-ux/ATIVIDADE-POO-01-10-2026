package br.com.starlog.model;

import java.util.Objects;

public class Carga {
    private final String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        // RN02 - Barreira Defensiva Fail-Fast
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");
        }
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso da carga deve ser maior que zero.");
        }
        
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    // RN01 - Encapsulamento & Imutabilidade (Sem setter para codigoRastreio)
    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso da carga deve ser maior que zero.");
        }
        this.pesoKg = pesoKg;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    // RN03 - Contrato de Hash baseado estritamente no codigoRastreio
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carga carga = (Carga) o;
        return Objects.equals(codigoRastreio, carga.codigoRastreio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoRastreio);
    }

    // RN04 - Representação Textual
    @Override
    public String toString() {
        return "Carga [rastreio=" + codigoRastreio + 
               ", categoria=" + categoria + 
               ", peso=" + pesoKg + "kg" + 
               ", seguro=R$ " + valorSeguro + "]";
    }
}
