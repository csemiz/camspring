package kodlama.io.rentACar.webApi.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.Models.Concretes.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.Optional;

@RestController //annotation
@RequestMapping("/api/brands") //addressleme
public class BrandsController {

    @Autowired
    private BrandService brandService;
    private BrandRepository brandRepository;

    @GetMapping("/getall")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @PostMapping("/postbrand")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        try {
            Brand _brand = brandRepository.save(new Brand(brand.getId(), brand.getName()));
            return new ResponseEntity<>(_brand, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
