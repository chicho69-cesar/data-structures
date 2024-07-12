package org.chicho69.cesar.hash_tables;

public class TestHashTable {
    public void run() {
        HashTable table = new HashTable(8);
        String[] elements = {"20", "33", "21", "10", "12", "14", "56", "100"};

        table.hashFunction(elements, table.array);
        table.show();

        String searchedKey = table.searchKey("100");

        if (searchedKey == null) {
            System.out.println("\nEl elemeneto 100 no esta en la tabla");
        } else {
            System.out.println("\nEl elemento 100 esta en la tabla");
        }
    }
}
