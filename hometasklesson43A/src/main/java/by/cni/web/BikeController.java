package by.cni.web;

import by.cni.domain.TypeOfBike;
import by.cni.dto.BikeDto;
import by.cni.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    @GetMapping("/page/{number}/{size}")
    public List<BikeDto> getBikes(@PathVariable("number") int number, @PathVariable("size") int size){
        PageRequest pageRequest = PageRequest.of(number, size);
        return bikeService.findAll(pageRequest);
    }

    @GetMapping("/{id}")
    public BikeDto getBikeById(@PathVariable("id") UUID id){
        return bikeService.findById(id);
    }

    @PostMapping
    public BikeDto createBike(@RequestBody BikeDto bikeDto) {
        return bikeService.save(bikeDto);
    }

    @PutMapping("/{id}")
    public BikeDto updateBike(@PathVariable("id") UUID id, @RequestBody BikeDto bikeDto) {
        return bikeService.update(id, bikeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable("id") UUID id){
        bikeService.delete(id);
    }

    @GetMapping("/all/{manufacturer}")
    public List<BikeDto> getByManufacturer(@PathVariable("manufacturer") String manufacturer){
        return bikeService.findByManufacturer(manufacturer);
    }

    @GetMapping("/alltype/{type}")
    public List<BikeDto> getByType(@PathVariable("type") TypeOfBike type){
        return bikeService.findByType(type);
    }
}
