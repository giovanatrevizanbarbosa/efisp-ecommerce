package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Address;

import java.util.List;
import java.util.UUID;

public class AddressService {
    private final IDao<Address> dao = Dao.getInstance(Address.class);

    protected Address toEntity(AddressDTO address) {
        return new Address(
            address.id(),
            address.street(),
            address.number(),
            address.city(),
            address.state(),
            address.zipCode()
        );
    }

    protected AddressDTO toDTO(Address address) {
        return new AddressDTO(
            address.getId(),
            address.getStreet(),
            address.getNumber(),
            address.getCity(),
            address.getState(),
            address.getZip()
        );
    }

    public boolean add(AddressDTO address) {
        return dao.add(toEntity(address));
    }

    public boolean update(UUID id, AddressDTO address) {
        return dao.update(id, toEntity(address));
    }

    public boolean delete(UUID id) {
        return dao.delete(id);
    }

    public AddressDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }

    public List<AddressDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }
}
