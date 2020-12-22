package clothes;

import clothes.elements.*;
import clothes.type.TypeOfUpperClothes;

import java.util.Objects;

public class UpperClothes extends ElementOfClothes implements Display{
    private TypeOfUpperClothes typeOfUpperClothes;

    public UpperClothes(Size size1, Color color1, Brand brand1, TypeOfUpperClothes typeOfUpperClothes1){
        super(size1, color1, brand1);
        this.typeOfUpperClothes = typeOfUpperClothes1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        UpperClothes guest = (UpperClothes) obj;
        return typeOfUpperClothes == guest.typeOfUpperClothes;
    }

    public String getTypeOfUpperClothes() {
        return typeOfUpperClothes.getUpper_s();
    }

    @Override
    public void display() {
        System.out.println("Upper Clothes: ");
        super.display();
        System.out.println("Type of upper clothes: " + typeOfUpperClothes+ "\n");
    }
}
