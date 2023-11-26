package data;

import Model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryData {
    private List<Entry> entries;

    public EntryData() {
        this.entries = new ArrayList<>();
    };

    public void addEntry(Entry entry) {
        entries.add(entry);
    };

    public void getEntries() {
        this.entries.stream().forEach(entry -> {
            System.out.println(entry);
        });
    };
    };