package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;

import java.util.Map;
import java.util.UUID;

/**
 * @param id Cart's id
 * @param ownerEmail Cart's owner email
 * @param items Cart's items
 * @param totalPrice Cart's total price
 */

// Map<ProductId, Item>
public record CartDTO(UUID id, String ownerEmail, Map<UUID, Item> items, double totalPrice) {
}
