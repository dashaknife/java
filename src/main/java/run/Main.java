//package run;
//
//import clothes.*;
//import clothes.elements.*;
//import clothes.type.*;
//
//import java.util.ArrayList;
//
//public class Main {
//
//    public static void main(String[] args) {
//        ArrayList<Look> looks = new ArrayList<>();
//        Look monday = new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
//                                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300);
//        Sale sale1 = new Sale("Black Friday");
//        sale1.changePrice(monday, 200);
//        //sale1.display();
//
//        //Look.Look1 tuesday = new Look.Look1("Tuesday", new UpperClothes(Size.S, Color.Wt, Brand.Ch, TypeOfUpperClothes.Dress));
//        //tuesday.display();
//
//        Look wednesday = new Look("Wednesday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Blouse),
//                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Leggings), 400);
//
//        //Look thursday = new Look();
//        //thursday.input();
//        Look thursday = new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
//                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 200);
//
//        looks.add(monday);
//        looks.add(wednesday);
//        looks.add(thursday);
//
//        Wardrobe wardrobe1 = new Wardrobe(looks);
//        wardrobe1.display();
//
//        System.out.println(monday.equals(thursday));
//    }
//}
