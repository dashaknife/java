package models.elements;

import exception.WrongInputException;

public enum Brand {
    Ch ("Chanel"),
    GG ("Gucci"),
    Za ("Zara"),
    Fe ("Fendi"),
    Mg ("Mango");
    private String brand_s;

    Brand(String brand_s) {
        this.brand_s = brand_s;
    }

    public String getBrand_s() {
        return brand_s;
    }

    public static Brand getTypeByUrl(String url) throws WrongInputException {
        for (Brand env : values()) {
            if (env.getBrand_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("None brand found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Brand: "+ brand_s;
    }
}
