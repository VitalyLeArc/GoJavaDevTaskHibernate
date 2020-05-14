
import service.DeveloperService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println(DeveloperService.getDeveloperService().getDeveloperById(2L));
    }
}
