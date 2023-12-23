package kodlama.io.rentACar.Models.Concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema="ceren",name="brand")
public class Brand {

    @Id
    @Positive
    private Integer id;
    @Column(nullable = false)
    private String name;

}
