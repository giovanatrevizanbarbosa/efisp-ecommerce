package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.ItemDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.entitys.Product;

import java.util.List;
import java.util.UUID;

public class ItemService {

    private final IDao<Item> items = Dao.getInstance(Item.class);
    private final ProductService productService = new ProductService();

    protected Item toEntity(ItemDTO itemDTO) {
        return new Item(itemDTO.id(), itemDTO.cartId(), productService.toEntity(itemDTO.productDTO()), itemDTO.quantity());
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

    public void checkout(UUID id, UUID orderId) {
        ProductService productService = new ProductService();

        List<ItemDTO> itemDTOS = getItemsByCartId(id);


        for (ItemDTO item : itemDTOS) {
            ItemDTO updatedItem = new ItemDTO(item.id(), item.productDTO(), orderId, item.quantity());
            updateItem(item.id(), updatedItem);
        }

        for (ItemDTO item : itemDTOS) {
            Product product = productService.toEntity(item.productDTO());
            Product updatedProduct = new Product(product.getId(), product.getName(), product.getPrice(), product.getBrand(), product.getDescription(), product.getDepartment(), product.getStock() - item.quantity(), product.getPhoto());
            productService.update(product.getId(), productService.toDTO(updatedProduct));
        }


    }
}
