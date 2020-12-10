package clothes;

public class Sale implements Display{
    private String nameSale;

    public Sale(String nameSale){
        this.nameSale = nameSale;
    }

    public void changePrice(Look look, float newPrice){
        look.setPrice(newPrice);
    }

    @Override
    public void display() {
        System.out.println(nameSale);
    }
}
