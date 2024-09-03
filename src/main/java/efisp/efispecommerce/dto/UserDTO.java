package efisp.efispecommerce.dto;

/**
 * @param id User's id
 * @param name User's name
 * @param email User's email
 * @param password User's password
 */
public record UserDTO(Long id, String name, String email, String password) {
}
