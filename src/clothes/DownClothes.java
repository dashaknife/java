package clothes;

import clothes.elements.*;
import clothes.type.TypeOfDownClothes;

public class DownClothes extends ElementOfClothes implements Display{
    private TypeOfDownClothes typeOfDownClothes;

    public DownClothes(Size size1, Color color1, Brand brand1, TypeOfDownClothes typeOfDownClothes1){
        super(size1, color1, brand1);
        this.typeOfDownClothes = typeOfDownClothes1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {  return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false;}
        DownClothes guest = (DownClothes) obj;
        return typeOfDownClothes == guest.typeOfDownClothes;
    }

    @Override
    public void display() {
        System.out.println("Down Clothes: ");
        super.display();
        System.out.println("Type of down clothes: "+ typeOfDownClothes);
    }
}
