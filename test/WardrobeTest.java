import clothes.*;
import clothes.type.*;
import clothes.elements.*;
import exception.WrongInputException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WardrobeTest {
    @Test
    public void EqualsLook1_IsObjectSame_True(){
        Look.Look1 look1 = new Look.Look1("Tuesday", new UpperClothes(Size.S, Color.Wt, Brand.Ch, TypeOfUpperClothes.Dress));
        Look.Look1 look2 = new Look.Look1("Tuesday", new UpperClothes(Size.S, Color.Wt, Brand.Ch, TypeOfUpperClothes.Dress));
        Assert.assertTrue(look1.equals(look2) && look2.equals(look1));
        //look1.display();
    }

    @Test
    public void EqualsLook_IsObjectSame_True(){
        Look look1 = new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300);
        Look look2 = new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300);
        Assert.assertTrue(look1.equals(look2) && look2.equals(look1));
        //look1.display();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Input_IncorrectInput_ExceptionThrown(){
        Look look = new Look();

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("No enum found with url: [Pa] in Down Clothes");

        String str1 = "Monday 200 Jumper small black Gucci Pa middle black Gucci";
        look.input(str1);
    }

    @Test
    public void ChangePrice_ChangePriceField_True(){
        Look look = new Look("Monday", new UpperClothes(Size.S, Color.Bk, Brand.GG, TypeOfUpperClothes.Jumper),
                       new DownClothes(Size.M, Color.Wt, Brand.Ch, TypeOfDownClothes.Jeans), 300);
        Sale sale1 = new Sale("Black Friday");

        sale1.changePrice(look, 200);
        //sale1.display();
        //look.display();
    }
}
