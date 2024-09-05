package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Item;
import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.List;
import java.util.UUID;

/**
 * @param id Order's id
 * @param user Order's user
 * @param items Order's items
 * @param paymentMethod Order's payment method
 * @param address Order's address
 */
public record OrderDTO(UUID id, UserDTO user, List<Item> items, PaymentMethod paymentMethod, AddressDTO address) {
}
