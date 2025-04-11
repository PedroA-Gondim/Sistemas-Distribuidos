package br.ufu.facom.gbc074.kvs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

public class StorageEngine {
    private final ConcurrentHashMap<String, List<VersionedValue>> store = new ConcurrentHashMap<>();

    private static class VersionedValue {
        String value;
        int version;
    }

    public synchronized int insert(String key, String value) {
        List<VersionedValue> entries = store.computeIfAbsent(key, k -> new ArrayList<>());
        int newVersion = entries.isEmpty() ? 1 : entries.get(entries.size() - 1).version + 1;
        VersionedValue newEntry = new VersionedValue();
        newEntry.value = value;
        newEntry.version = newVersion;
        entries.add(newEntry);
        return newVersion;
    }

    //tratar outras operações
}