package br.com.starlog.exception;
import br.com.starlog.exception.CapacidadeExcedidaException; // Ajuste para o pacote correto onde a exceção está

public class CapacidadeExcedidaException extends Exception {
    
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
