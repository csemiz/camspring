package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.Models.Concretes.Brand;
import kodlama.io.rentACar.Models.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();
    void createBrand(BrandDto brand);

}
