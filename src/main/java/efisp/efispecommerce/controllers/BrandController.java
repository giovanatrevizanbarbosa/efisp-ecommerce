package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.BrandDTO;
import efisp.efispecommerce.models.service.BrandService;

import java.util.List;
import java.util.UUID;

public class BrandController {

    BrandService brandService = new BrandService();

    public void addBrand(BrandDTO brandDTO) {
        brandService.add(brandDTO);
    }

    public BrandDTO getById(UUID id) {
        return brandService.getById(id);
    }

    public List<BrandDTO> getAll() {
        return brandService.getAll();
    }
}
