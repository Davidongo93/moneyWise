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

    public List<Entry> getEntries() {
        return entries;
    }
public void showEntries(){
        getEntries().stream().forEach(entry -> {
            System.out.println(entry.getId());
            System.out.println(entry.getAmount());
            System.out.println(entry.getDate());
            System.out.println(entry.getDescription());
            System.out.println(entry.getType());
        });
}
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
};