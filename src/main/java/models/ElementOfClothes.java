package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.elements.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ElementOfClothes {
    private Size size;
    private Color color;
    private Brand brand;
}
