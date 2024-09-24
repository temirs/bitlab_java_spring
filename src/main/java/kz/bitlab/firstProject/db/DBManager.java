package kz.bitlab.firstProject.db;

import kz.bitlab.firstProject.model.Item;
import lombok.Getter;

import java.util.ArrayList;

public class DBManager {
    private static long id = 6L;
    @Getter
    static ArrayList<Item> items = new ArrayList<>();

    static {
        items.add(new Item(1L, "Lenovo ThinkBook", "16GB RAM 512GB SSD Intel Core-i5", 1299.99));
        items.add(new Item(2L, "Mac Book Pro", "8GB RAM 250GB SSD Intel Core-i7", 1199.99));
        items.add(new Item(3L, "Lenovo Legion", "32GB RAM 512GB SSD Intel Core-i7", 1399.99));
        items.add(new Item(4L, "Mac Book Pro", "16GB RAM 1GB SSD Apple M-1", 1699.99));
        items.add(new Item(5L, "Mac Book Pro", "16GB RAM 1GB SSD Apple M-1", 1699.99));
    }

    public static void addItem(Item item) {
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Item getItemById(int id) {
        return items.stream().filter(s -> s.getId() == id).findFirst().orElseThrow();
    }

    public static void updateItem(Item item) {
        for (Item it : items) {
            if (it.getId().equals(item.getId())) {
                it.setName(item.getName());
                it.setPrice(item.getPrice());
                it.setDescription(item.getDescription());
            }
        }
    }

    public static void deleteItem(long id) {
        items.removeIf(s -> s.getId() == id);
    }
}
