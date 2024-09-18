package kz.bitlab.firstProject.service;

import kz.bitlab.firstProject.model.Items;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotebookService {
    private static long id = 6L;
    @Getter
    static ArrayList<Items> items = new ArrayList<>();

    static {
        items.add(new Items(1L, "Lenovo ThinkBook", "16GB RAM 512GB SSD Intel Core-i5", 1299.99));
        items.add(new Items(2L, "Mac Book Pro", "8GB RAM 250GB SSD Intel Core-i7", 1199.99));
        items.add(new Items(3L, "Lenovo Legion", "32GB RAM 512GB SSD Intel Core-i7", 1399.99));
        items.add(new Items(4L, "Mac Book Pro", "16GB RAM 1GB SSD Apple M-1", 1699.99));
        items.add(new Items(5L, "Mac Book Pro", "16GB RAM 1GB SSD Apple M-1", 1699.99));
    }

    public static void addItem(Items item) {
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItemById(int id) {
        return items.stream().filter(s -> s.getId() == id).findFirst().orElseThrow();
    }

    public static void updateItem(Items item) {
        for (Items it : items) {
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
