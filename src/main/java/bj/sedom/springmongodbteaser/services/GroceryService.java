package bj.sedom.springmongodbteaser.services;

import bj.sedom.springmongodbteaser.models.GroceryItem;
import bj.sedom.springmongodbteaser.repositories.GroceryItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryService {

    private final GroceryItemRepository groceryItemRepository;

    //@PostConstruct
    public void init() {

        groceryItemRepository.deleteAll();

        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

        createGroceryItems();

        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");

        showAllGroceryItems();

        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

        getGroceryItemByName("Whole Wheat Biscuit");

        System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");

        getItemsByCategory("millets");

        System.out.println("\n-----------UPDATE CATEGORY NAME OF ALL GROCERY ITEMS----------------\n");

        updateCategoryName("snacks");

        System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");

        deleteGroceryItem("Kodo Millet");

        System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");

        findCountOfGroceryItems();

        System.out.println("\n-------------------THANK YOU---------------------------");

    }



    public void createGroceryItems() {
        System.out.println("Data creation started...");

        groceryItemRepository.save(new GroceryItem("Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepository.save(new GroceryItem("XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepository.save(new GroceryItem("Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepository.save(new GroceryItem("Healthy Pearl Millet", 1, "millets"));
        groceryItemRepository.save(new GroceryItem("Bonny Cheese Crackers Plain", 6, "snacks"));

        System.out.println("Data creation complete...");
    }

    public String getItemDetails(GroceryItem item) {

        System.out.println(
                "Item Name: " + item.getName() +
                        ", \nItem Quantity: " + item.getQuantity() +
                        ", \nItem Category: " + item.getCategory()
        );
        return "";
    }


    public void showAllGroceryItems() {

        List<GroceryItem> itemList = groceryItemRepository.findAll();

        itemList.forEach(item -> System.out.println(getItemDetails(item)));
    }

    public void getGroceryItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepository.findItemByName(name);
        System.out.println(getItemDetails(item));
    }

    public void getItemsByCategory(String category) {
        System.out.println("Getting items for the category " + category);
        List<GroceryItem> list = groceryItemRepository.findAllByCategory(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }

    public void findCountOfGroceryItems() {
        long count = groceryItemRepository.count();
        System.out.println("Number of documents in the collection = " + count);
    }

    public void updateCategoryName(String category) {
        String newCategory = "munchies";

        List<GroceryItem> list = groceryItemRepository.findAllByCategory(category);

        list.forEach(item -> {
            item.setCategory(newCategory);
        });

        List<GroceryItem> itemsUpdated = groceryItemRepository.saveAll(list);

        System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
    }

    public void deleteGroceryItem(String id) {
        groceryItemRepository.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
    }

}
