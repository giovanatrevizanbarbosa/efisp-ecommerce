package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Address's id
 * @param street Address's street
 * @param number Address's number
 * @param city Address's city
 * @param state Address's state
 * @param zipCode Address's zipCode
 */
public record AddressDTO(UUID id, String street, String number, String city, String state, String zipCode) {
}
