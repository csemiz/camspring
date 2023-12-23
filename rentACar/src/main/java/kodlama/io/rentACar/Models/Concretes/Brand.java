package kodlama.io.rentACar.Models.Concretes;

import jakarta.persistence.*;
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
    private int id;
    @Column(nullable = false)
    private String name;


 /*   @Override
    public String toString() {
        return "Tutorial [id=" + id + ", name=" + name + "]";
    }
*/
}
