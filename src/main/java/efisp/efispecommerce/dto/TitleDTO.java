package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id Title's id
 * @param name Title's name
 * @param level Title's level
 */
public record TitleDTO(UUID id, String name, int level) {
}
