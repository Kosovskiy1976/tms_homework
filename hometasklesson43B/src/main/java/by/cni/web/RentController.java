package by.cni.web;

import by.cni.dto.BikeDto;
import by.cni.dto.TypeOfBike;
import by.cni.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rent")
public class RentController {

    private final RentService rentService;

    @PostMapping("/bike")
    public BikeDto createBike(@RequestBody BikeDto bikeDto) {
        return rentService.register(bikeDto);
    }


    @GetMapping("/{id}")
    public BikeDto getBikeById(@PathVariable("id") UUID id){
        return rentService.findById(id);
    }

    @GetMapping("/all/{manufacturer}")
    public List<BikeDto> getByManufacturer(@PathVariable("manufacturer") String manufacturer){
        return rentService.findByManufacturer(manufacturer);
    }

    @GetMapping("/alltype/{type}")
    public List<BikeDto> getByType(@PathVariable("type") TypeOfBike type){
        return rentService.findByType(type);
    }

    @GetMapping("/page/{number}/{size}")
    public List<BikeDto> getBikes(@PathVariable("number") int number, @PathVariable("size") int size){
       return rentService.findAll(number, size);
    }
}
