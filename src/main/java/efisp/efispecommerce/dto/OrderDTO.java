package efisp.efispecommerce.dto;

import efisp.efispecommerce.models.entitys.Address;
import efisp.efispecommerce.models.entitys.Cart;
import efisp.efispecommerce.models.entitys.User;
import efisp.efispecommerce.models.enums.PaymentMethod;

/**
 * @param id Order's id
 * @param user Order's user
 * @param cart Order's cart
 * @param paymentMethod Order's payment method
 * @param address Order's address
 */
public record OrderDTO(Long id, User user, Cart cart, PaymentMethod paymentMethod, Address address) {
}
