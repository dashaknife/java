package services;

import models.*;

import java.util.List;

public interface LookService {
    List<Look> getLooks ();
    Look getLookByName (String name);

}
