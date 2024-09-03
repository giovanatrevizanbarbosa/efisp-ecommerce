package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.enums.PaymentMethod;

import java.util.UUID;

/**
 * @param id Order's id
 * @param user Order's user
 * @param cart Order's cart
 * @param paymentMethod Order's payment method
 * @param address Order's address
 */
public record OrderDTO(UUID id, UserDTO user, CartDTO cart, PaymentMethod paymentMethod, AddressDTO address) {
}
