package br.com.starlog.model;
import br.com.starlog.exception.CapacidadeExcedidaException; 

import java.util.ArrayList;
import java.util.List;

public class ModuloCarga {
    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    // RN06 - Atributos e Inicialização
    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>();
    }

    // RN07 - Trava Física de Capacidade (Fail-Fast)
    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (this.cargas.size() >= this.capacidadeMaxima) {
            throw new CapacidadeExcedidaException("Capacidade maxima de " + this.capacidadeMaxima + " atingida no modulo " + this.idModulo);
        }
        this.cargas.add(carga);
    }

    // RN08 - Processamento Declarativo (Streams API)
    public double calcularSeguroTotal() {
        return this.cargas.stream()
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    public long contarPorCategoria(String categoria) {
        return this.cargas.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .count();
    }

    public double calcularSeguroPesadas(double pesoCorte) {
        return this.cargas.stream()
                .filter(c -> c.getPesoKg() > pesoCorte)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }

    // Getters e Setters auxiliares
    public String getIdModulo() {
        return idModulo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Carga> getCargas() {
        return new ArrayList<>(cargas); // Retorna cópia defensiva
    }
}
