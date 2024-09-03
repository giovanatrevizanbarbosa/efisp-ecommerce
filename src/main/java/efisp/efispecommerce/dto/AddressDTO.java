package efisp.efispecommerce.dto;

import java.util.UUID;

public record AddressDTO(UUID id, String street, String number, String city, String state, String zipCode) {
}
