package clothes;

import java.util.ArrayList;
import java.util.ListIterator;

public class Wardrobe implements Display{
    private ArrayList<Look> looks;

    public Wardrobe(ArrayList<Look> looks){
        this.looks = new ArrayList<>();
        this.looks = looks;
    }

    @Override
    public void display() {
        ListIterator<Look> lookListIterator = looks.listIterator();
        while (lookListIterator.hasNext()){
            lookListIterator.next().display();
        }
    }
}
