package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.Models.Concretes.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    List<Brand> createBrand(List<Brand> brandList);

}
