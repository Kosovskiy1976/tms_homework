package by.cni.service.impl;

import by.cni.client.BikeClient;
import by.cni.dto.BikeDto;
import by.cni.dto.TypeOfBike;
import by.cni.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final BikeClient bikeClient;

    @Override
    public BikeDto register(BikeDto bikeDto) {
        return bikeClient.register(bikeDto);
    }

    @Override
    public BikeDto findById(UUID id) {
        BikeDto bikeById = bikeClient.getBikeById(id);
        return bikeById;
    }

    @Override
    public List<BikeDto> findByManufacturer(String manufacturer) {
        List<BikeDto> byManufacturer = bikeClient.getByManufacturer(manufacturer);
        return byManufacturer;
    }

    @Override
    public List<BikeDto> findByType(TypeOfBike type) {
        List<BikeDto> byType = bikeClient.getByType(type);
        return byType;
    }

    @Override
    public List<BikeDto> findAll(int number, int size) {
        List<BikeDto> bikes = bikeClient.getBikes(number, size);
        return bikes;
    }
}
