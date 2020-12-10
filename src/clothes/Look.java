package clothes;

import clothes.elements.*;
import clothes.type.TypeOfDownClothes;
import clothes.type.TypeOfUpperClothes;
import exception.WrongInputException;

import java.util.Objects;
import java.util.Scanner;

public class Look implements Display{
    private UpperClothes upperClothes;
    private DownClothes downClothes;
    private String name;
    private Float price;

    public Look () {}

    public Look(String name1, UpperClothes upperClothes1, DownClothes downClothes1, float price1){
        this.name = name1;
        this.upperClothes = upperClothes1;
        this.downClothes = downClothes1;
        this.price = price1;
    }

    void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true;  }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        Look guest = (Look) obj;
        return price.equals(guest.price) && (Objects.equals(name, guest.name)) &&
                upperClothes.equals(guest.upperClothes) && downClothes.equals(guest.downClothes);
    }

    public void input(String str1) throws WrongInputException{
        String str = str1;

        try {
            String tmp[] = str.split(" ", 10);
            if (tmp.length < 10) throw new WrongInputException("Not all data entered");
            this.name = tmp[0];
            this.price = Float.valueOf(tmp[1]);
            this.upperClothes = new UpperClothes(Size.getTypeByUrl(tmp[3]), Color.getTypeByUrl(tmp[4]), Brand.getTypeByUrl(tmp[5]), TypeOfUpperClothes.getTypeByUrl(tmp[2]));
            this.downClothes = new DownClothes(Size.getTypeByUrl(tmp[7]), Color.getTypeByUrl(tmp[8]), Brand.getTypeByUrl(tmp[9]), TypeOfDownClothes.getTypeByUrl(tmp[6]));
        }
        catch (WrongInputException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public void display() {
        System.out.println(name + "\nPrice: " + price);
        upperClothes.display();
        downClothes.display();
        System.out.println("_______________________________________");
    }

    public static class Look1{
        private UpperClothes upperClothes;
        private String name;
        public Look1(String name1, UpperClothes upperClothes1) {
            this.name = name1;
            this.upperClothes = upperClothes1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) { return true; }
            if (obj == null || obj.getClass() != this.getClass()) { return false; }
            Look.Look1 guest = (Look.Look1) obj;
            return (Objects.equals(name, guest.name)) && upperClothes.equals(guest.upperClothes);
        }

        public void display(){
            System.out.println(name);
            upperClothes.display();
            System.out.println("_______________________________________");
        }
    }
  }
