package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import models.type.TypeOfUpperClothes;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UpperClothes extends ElementOfClothes {
    private TypeOfUpperClothes typeOfUpperClothes;
}
