package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.Models.dto.BrandDto;
import kodlama.io.rentACar.business.abstracts.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //annotation
@RequestMapping("/api/brands") //addressleme
public class BrandsController {

    @Autowired
    private BrandService brandService;


    @GetMapping("/getall")
    public List<BrandDto> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public BrandDto getById(@PathVariable int id)
    {
        return brandService.getById(id);
    }

    @PostMapping("/postbrand")
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto) {
        try {
            brandService.createBrand(brandDto);
            return new ResponseEntity<>(brandDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<BrandDto> updateBrand(@RequestBody BrandDto brandDto, @PathVariable int id)
    {
        try {
            brandService.updateBrand(brandDto);
            return new ResponseEntity<>(brandDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.deleteById(id);
    }

}
