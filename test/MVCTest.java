import controllers.LookController;
import models.DownClothes;
import models.elements.Brand;
import models.elements.Color;
import models.elements.Size;
import models.type.TypeOfDownClothes;
import org.junit.Assert;
import org.junit.Test;
import repository.LookRepository;
import services.LookService;
import services.LookServiceImpl;

public class MVCTest {
    @Test
    public void Test1 () {
        LookController lookController = new LookController(new LookServiceImpl(new LookRepository()));
    }
}
