package by.cni.service;

import by.cni.domain.TypeOfBike;
import by.cni.dto.BikeDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface BikeService {

    List<BikeDto> findAll(PageRequest pageRequest);

    BikeDto findById(UUID id);

    BikeDto save(BikeDto bikeDto);

    BikeDto update(UUID id, BikeDto bikeDto);

    void delete(UUID id);

    List<BikeDto> findByManufacturer(String manufacturer);

    List<BikeDto> findByType(TypeOfBike type);
}
