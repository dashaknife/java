package models.type;

import exception.WrongInputException;

public enum TypeOfUpperClothes{
    Undershirt ("Undershirt"),
    Tshirt ("T-shirt"),
    Blouse ("Blouse"),
    Jumper ("Jumper"),
    Dress ("Dress");
    public String upper_s;

    TypeOfUpperClothes(String upper_s) {
        this.upper_s = upper_s;
    }

    public String getUpper_s() {
        return upper_s;
    }

    public static TypeOfUpperClothes getTypeByUrl(String url) throws WrongInputException {
        for (TypeOfUpperClothes env : values()) {
            if (env.getUpper_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No enum found with url: [" + url + "] in Upper Clothes");
    }

    @Override
    public String toString() {
        return upper_s;
    }
}
