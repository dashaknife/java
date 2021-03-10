package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class Wardrobe {
    private ArrayList<Look> looks;
}
