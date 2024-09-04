package efisp.efispecommerce.models.dao;

import java.util.List;
import java.util.UUID;

/**
 * Interface that defines the methods that a repository must implement.
 * @param <T> The type of the object that the repository will manage.
 */
public interface IDao<T> {

    /**
     * Adds a new object to the repository.
     * @param newValue The object to be added.
     * @return True if the object was added successfully, false otherwise.
     */
    boolean add(Writable newValue);

    /**
     * Updates an object in the repository.
     * @param id The id of the object to be updated.
     * @param newValue The new object.
     * @return True if the object was updated successfully, false otherwise.
     */
    boolean update(UUID id, Writable newValue);

    /**
     * Deletes an object from the repository.
     * @param id The id of the object to be deleted.
     * @return True if the object was deleted successfully, false otherwise.
     */
    boolean delete(UUID id);

    /**
     * Gets an object from the repository by its id.
     * @param id The id of the object to be retrieved.
     * @return The object with the given id or null if it doesn't exist.
     */
    T getById(UUID id);

    /**
     * Gets all the objects in the repository.
     * @return A list with all the objects in the repository.
     */
    List<T> getAll();
}
