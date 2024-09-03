package efisp.efispecommerce.dto;

/**
 * @param id User's id
 * @param name User's name
 * @param email User's email
 * @param password User's password
 * @param title User's title
 */
public record AdmDTO(long id, String name, String email, String password, String title) {
}
