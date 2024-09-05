package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.models.service.ItemService;

import java.util.List;
import java.util.UUID;

public class ItemController {
    private final ItemService service;

    public ItemController() {
         service = new ItemService();
    }

    public boolean addItem(ItemDTO itemDTO) {
        return service.addItem(itemDTO);
    }

    public boolean updateItem(UUID id, ItemDTO itemDTO) {
        return service.updateItem(id, itemDTO);
    }

    public boolean deleteItem(UUID id) {
        return service.deleteItem(id);
    }

    public ItemDTO getItemById(UUID id) {
        return service.getItemById(id);
    }

    public List<ItemDTO> getItemsByCartId(UUID cartId) { return service.getItemsByCartId(cartId); }

}
