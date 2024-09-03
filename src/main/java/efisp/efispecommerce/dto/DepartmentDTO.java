package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Department's id
 * @param name Department's name
 * @param description Department's description
 */
public record DepartmentDTO(UUID id, String name, String description) {
}
