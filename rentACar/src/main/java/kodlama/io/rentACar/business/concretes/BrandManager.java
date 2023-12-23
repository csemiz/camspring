package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Models.Concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        //İs Kuralları
        return brandRepository.getAll();
    }

    @Override
    public List<Brand> createBrand(List<Brand> brandList) {
        List<Brand> savedBrands = new ArrayList<>();

        for (Brand brand : brandList) {
            savedBrands.add(brandRepository.save(brand));
        }
        return savedBrands;
    }
}
