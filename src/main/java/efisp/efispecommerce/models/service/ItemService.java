package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Item;

import java.util.List;
import java.util.UUID;

public class ItemService {

    private final IDao<Item> items = Dao.getInstance(Item.class);
    private final ProductService productService = new ProductService();

    protected Item toEntity(ItemDTO itemDTO) {
        return new Item(itemDTO.id(), itemDTO.cardId(), productService.toEntity(itemDTO.productDTO()), itemDTO.quantity());
    }

    protected ItemDTO toDTO(Item item) {
        return new ItemDTO(item.getId(), productService.toDTO(item.getProduct()), item.getCartId(), item.getQuantity());
    }

    public boolean addItem(ItemDTO item) {
        return items.add(toEntity(item));
    }

    public boolean updateItem(UUID id, ItemDTO item) {
        return items.update(id, toEntity(item));
    }

    public boolean deleteItem(UUID id) {
        return items.delete(id);
    }

    public ItemDTO getItemById(UUID id) {
        return toDTO(items.getById(id));
    }

    public List<ItemDTO> getAll() {
        return items.getAll().stream().map(this::toDTO).toList();
    }

    public List<ItemDTO> getItemsByCartId(UUID cartId) {
        return items.getAll().stream().filter(i -> i.getCartId().equals(cartId)).map(this::toDTO).toList();
    }
}
