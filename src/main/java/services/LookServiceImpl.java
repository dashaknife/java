package services;

import exception.LookNotFoundException;
import lombok.AllArgsConstructor;
import models.Look;
import repository.LookRepository;
import java.util.List;

@AllArgsConstructor
public class LookServiceImpl implements LookService {
    LookRepository lookRepository;

    public List<Look> getLooks () {
        return lookRepository.getAllLooks();
    }
    public Look getLookByName (String name) {
        return  lookRepository.getAllLooks().stream()
                .filter(sub -> sub.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new LookNotFoundException(name));
    }
}
