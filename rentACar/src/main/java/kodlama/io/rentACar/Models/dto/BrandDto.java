package kodlama.io.rentACar.Models.dto;

import kodlama.io.rentACar.Models.Concretes.Brand;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private Integer id;
    private String name;

    public Brand toEntity() {
        Brand brand = new Brand();
        brand.setId(this.getId());
        brand.setName(this.getName());
        return brand;
    }

    public static BrandDto fromEntity(Brand brand){
        BrandDto brandDto=new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        return brandDto;
    }

}
