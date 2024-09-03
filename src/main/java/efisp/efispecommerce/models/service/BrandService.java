package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Brand;

import java.util.List;
import java.util.UUID;

public class BrandService {

    private final IDao<Brand> dao = Dao.getInstance(Brand.class);

    private Brand toEntity(BrandDTO brandDTO){
        return new Brand(brandDTO.id(), brandDTO.name());
    }

    private BrandDTO toDTO(Brand brand){
        return new BrandDTO(brand.getId(), brand.getName());
    }

    public boolean add(BrandDTO brand) {
        return dao.add(toEntity(brand));
    }

    public Brand getByName(String brand) {
        return dao.getAll().stream().filter(b -> b.getName().equalsIgnoreCase(brand)).findFirst().orElse(null);
    }

    public List<BrandDTO> getAll() {
        return dao.getAll().stream().map(this::toDTO).toList();
    }

    public BrandDTO getById(UUID id) {
        return toDTO(dao.getById(id));
    }
}
