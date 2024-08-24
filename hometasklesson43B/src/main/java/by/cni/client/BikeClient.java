package by.cni.client;

import by.cni.config.FeignConfig;
import by.cni.dto.BikeDto;
import by.cni.dto.TypeOfBike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(name = "bikeClient", url = "${app.client.bike.url}", path = "/bikes", configuration = FeignConfig.class)
public interface BikeClient {

    @PostMapping
    BikeDto register(@RequestBody BikeDto bikeDto);

    @GetMapping("/{id}")
    BikeDto getBikeById(@PathVariable("id") UUID id);

    @GetMapping("/all/{manufacturer}")
    List<BikeDto> getByManufacturer(@PathVariable("manufacturer") String manufacturer);

    @GetMapping("/alltype/{type}")
    List<BikeDto> getByType(@PathVariable("type") TypeOfBike type);

    @GetMapping("/page/{number}/{size}")
    List<BikeDto> getBikes(@PathVariable("number") int number, @PathVariable("size") int size);

}
