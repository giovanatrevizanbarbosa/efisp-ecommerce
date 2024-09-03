package efisp.efispecommerce.models.service;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.models.dao.Dao;
import efisp.efispecommerce.models.dao.IDao;
import efisp.efispecommerce.models.entitys.Brand;

import java.util.List;

public class BrandService {

    private final IDao<Brand> dao = Dao.getInstance(Brand.class);

    private Brand mapBrandDTOToEntity(BrandDTO brandDTO){
        return new Brand(brandDTO.id(), brandDTO.name());
    }

    private BrandDTO mapBrandEntityToDTO(Brand brand){
        return new BrandDTO(brand.getId(), brand.getName());
    }

    public boolean add(BrandDTO brand) {
        return dao.add(mapBrandDTOToEntity(brand));
    }

    public Brand getBrandByName(String brand) {
        return dao.getAll().stream().filter(b -> b.getName().equalsIgnoreCase(brand)).findFirst().orElse(null);
    }

    public List<BrandDTO> getAll() {
        return dao.getAll().stream().map(this::mapBrandEntityToDTO).toList();
    }

    public BrandDTO getById(long id) {
        return mapBrandEntityToDTO(dao.getById(id));
    }

    public Long getNextId() {
        return dao.getNextId();
    }
}
