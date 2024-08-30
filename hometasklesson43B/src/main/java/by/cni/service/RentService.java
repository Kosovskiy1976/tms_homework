package by.cni.service;

import by.cni.dto.BikeDto;
import by.cni.dto.TypeOfBike;

import java.util.List;
import java.util.UUID;

public interface RentService {

    List<BikeDto> findAll(int number, int size);

    BikeDto register(BikeDto bikeDto);

    BikeDto findById(UUID id);

    List<BikeDto> findByManufacturer(String manufacturer);

    List<BikeDto> findByType(TypeOfBike type);

}
