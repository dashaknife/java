package controllers;

import lombok.AllArgsConstructor;
import models.Look;
import services.LookService;

@AllArgsConstructor
public class LookController {
    LookService lookService;

    public Look findLookByName (String name) {
        return lookService.getLookByName(name);
    }
}
