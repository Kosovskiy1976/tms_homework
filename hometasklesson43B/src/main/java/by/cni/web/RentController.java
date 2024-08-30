package by.cni.web;

import by.cni.dto.BikeDto;
import by.cni.dto.ErrorDto;
import by.cni.dto.TypeOfBike;
import by.cni.service.RentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rent")
public class RentController {

    private final RentService rentService;
    @Operation(
            tags = "create"
    )
    @PostMapping("/bike")
    public BikeDto createBike(@RequestBody BikeDto bikeDto) {
        return rentService.register(bikeDto);
    }

    @Operation(
            tags = "search",
            summary = "search bike for id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "search was successfully",
                            content = @Content(
                                    mediaType = "application/application-json",
                                    schema = @Schema(implementation = BikeDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Bike is not found",
                            content = @Content(
                                    mediaType = "application/application-json",
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public BikeDto getBikeById(@PathVariable("id") UUID id){
        return rentService.findById(id);
    }

    @Operation(
            tags = "search",
            summary = "search bike for manufacturer",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "search was successfully",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = BikeDto.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Bike is not found",
                            content = @Content(
                                    mediaType = "application/application-json",
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
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
