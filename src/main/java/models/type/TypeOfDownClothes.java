package models.type;

import exception.WrongInputException;

public enum TypeOfDownClothes {
    Pants ("Pants"),
    Jeans ("Jeans"),
    Leggings ("Leggings"),
    Shorts ("Shorts"),
    Skirt ("Skirt");
    private String down_s;

    TypeOfDownClothes(String down_s) {
        this.down_s = down_s;
    }

    public String getDown_s() {
        return down_s;
    }

    public static TypeOfDownClothes getTypeByUrl(String url) throws WrongInputException {
        for (TypeOfDownClothes env : values()) {
            if (env.getDown_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No enum found with url: [" + url + "] in Down Clothes");
    }

    @Override
    public String toString() {
        return down_s;
    }
}
