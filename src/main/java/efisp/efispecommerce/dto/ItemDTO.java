package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Item's id
 * @param productDTO Item's product
 * @param cartId Item's card id
 * @param quantity Item's quantity
 */
public record ItemDTO(UUID id, ProductDTO productDTO, UUID cartId, int quantity) {
}
