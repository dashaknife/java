package views;

import models.*;


public interface View {
    public void displayElementOfClothes (ElementOfClothes elementOfClothes);
    public void displayDownClothes (DownClothes downClothes);
    public void displayUpperClothes (UpperClothes upperClothes);
    public void displayLook (Look look);
    public void displayWardrobe (Wardrobe wardrobe);
}
