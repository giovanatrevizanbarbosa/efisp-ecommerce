package efisp.efispecommerce.controllers;

import efisp.efispecommerce.dto.AddressDTO;
import efisp.efispecommerce.models.service.AddressService;

public class AddressController {

    AddressService addressService = new AddressService();

    public void addAddress(AddressDTO address) {
        addressService.add(address);
    }
}
