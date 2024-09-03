package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Brand's id
 * @param name Brand's name
 */
public record BrandDTO(UUID id, String name) {
}
