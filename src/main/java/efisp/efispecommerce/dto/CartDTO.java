package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;

import java.util.Map;

/**
 * @param id Cart's id
 * @param ownerEmail Cart's owner email
 * @param items Cart's items
 * @param totalPrice Cart's total price
 */

// Map<ProductId, Item>
public record CartDTO(Long id, String ownerEmail, Map<Long, Item> items, double totalPrice) {
}
