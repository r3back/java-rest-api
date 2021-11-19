package me.reb4ck.rest.controller.car;

import me.reb4ck.rest.model.list.CarList;
import me.reb4ck.rest.serializer.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping()
public final class CarController {
    @Autowired
    @Qualifier("parsingService")
    private ParsingService parsingService;
    @Value("${rest.server.url}")
    private String cocochesUrl;

    @GetMapping("/get_ford_cars")
    public ResponseEntity<?> getFordCards() {
        return ResponseEntity.ok(CarList.of(parsingService.parse(cocochesUrl, CarList.class).getCarList()
                .stream()
                .filter(car -> car.getBrandDescription().equalsIgnoreCase("FORD"))
                .collect(Collectors.toList())));
    }
}
