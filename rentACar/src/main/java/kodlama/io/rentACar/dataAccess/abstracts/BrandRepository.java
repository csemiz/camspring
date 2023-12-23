package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.Models.Concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query("SELECT b FROM Brand b")
    List<Brand> getAll();

    List<Brand> createBrand(List<Brand> brandList);


}



