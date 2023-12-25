package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Models.Concretes.Brand;
import kodlama.io.rentACar.Models.dto.BrandDto;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.exception.CreateBrandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
@Slf4j
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    //İs Kuralları
    @Override
    public List<BrandDto> getAll() {

        List<Brand> entities = brandRepository.getAll();
        return entities.stream()
                .map(entity -> new BrandDto(entity.getId(), entity.getName()))
                .toList();
    }

    @Override
    public BrandDto getById(int id) {
        BrandDto brandDto = brandRepository.getById(id);
        return brandDto;

    }


    @Override
    public void createBrand(BrandDto brandDto) throws CreateBrandException {

        try {
            Brand brand = brandDto.toEntity();
            brandRepository.save(brand);
        } catch (Exception e) {
            log.info("Exception while creating brand {}", e.getLocalizedMessage());
            throw new CreateBrandException(e);
        }
    }

    @Override
    public void updateBrand(BrandDto brandDto) {
        try {
            Brand updateBrand = brandDto.toEntity();
            brandRepository.findById(brandDto.getId()).map(brand -> {
                brand.setName(updateBrand.getName());
                brand.setId(updateBrand.getId());
                return brandRepository.save(brand);
            });
        } catch (Exception e) {
            log.info("Exception while creating brand {}", e.getLocalizedMessage());
            throw new CreateBrandException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        this.brandRepository.deleteById(id);
    }

}
