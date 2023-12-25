package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.Models.Concretes.Brand;
import kodlama.io.rentACar.Models.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();
    BrandDto getById(int id);
    void createBrand(BrandDto brand);
    void updateBrand(BrandDto brand);
    void deleteById(int id);
}
