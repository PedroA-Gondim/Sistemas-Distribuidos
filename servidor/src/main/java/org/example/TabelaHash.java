package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TabelaHash {
    // Map<Chave, List<VersionedValue>>
    private final ConcurrentHashMap<String, List<ValorVersao>> tabelaHash = new ConcurrentHashMap<>();

    private static class ValorVersao {

        String value;
        int version;

        public ValorVersao(String value, int newVersion) {
            this.value = value;
            this.version = newVersion;
        }
    }

    public synchronized int insert(String key, String value) {
        List<ValorVersao> insercoes = tabelaHash.computeIfAbsent(key, k -> new ArrayList<>());
        int novaVersao;
        if (insercoes.isEmpty()) {
            novaVersao = 1;
        } else {
            int lastVersion = insercoes.get(insercoes.size() - 1).version;
            novaVersao = lastVersion + 1;
        }        insercoes.add(new ValorVersao(value, novaVersao));
        return novaVersao;
    }

    // Implementar consulta, remoção, etc.
}
