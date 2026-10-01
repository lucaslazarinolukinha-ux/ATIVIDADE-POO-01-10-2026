package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    // RN09 - Indexação Associativa O(1)
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public void cadastrarModulo(ModuloCarga modulo) {
        if (modulo != null && modulo.getIdModulo() != null) {
            this.modulos.put(modulo.getIdModulo(), modulo);
        }
    }

    public ModuloCarga buscarModulo(String idModulo) {
        return this.modulos.get(idModulo);
    }
}
