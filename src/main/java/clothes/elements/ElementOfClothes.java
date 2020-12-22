package clothes.elements;

import clothes.Display;

public abstract class ElementOfClothes implements Display {
    private Size size;
    private Color color;
    private Brand brand;


    protected ElementOfClothes(Size size1, Color color1, Brand brand1){
        this.size = size1;
        this.color = color1;
        this.brand = brand1;
    }

    @Override
    public void display(){
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(size).append(" ")
                .append(color).append(" ")
                .append(brand));
    };
}
