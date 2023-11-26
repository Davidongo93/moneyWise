package data;

import Model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryData {
    private List<Entry> entries;

    public EntryData() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry){
        entries.add(entry);
    };
    // Métodos para almacenar y recuperar datos de entradas
}
