package by.cni.service.impl;

import by.cni.domain.BikeEntity;
import by.cni.domain.TypeOfBike;
import by.cni.dto.BikeDto;
import by.cni.exc.BikeException;
import by.cni.mapper.BikeMapper;
import by.cni.repository.BikeRepository;
import by.cni.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepo;
    private final BikeMapper bikeMapper;

    @Override
    public List<BikeDto> findAll(PageRequest pageRequest) {
        List<BikeEntity> all = bikeRepo.findByRentedFalse(pageRequest);
        return bikeMapper.toDtos(all);
    }

    @Override
    public BikeDto findById(UUID id) {
        Optional<BikeEntity> bikeOpt = bikeRepo.findById(id);
        if (bikeOpt.isPresent()) {
            return bikeMapper.toDto(bikeOpt.get());
        }
        throw new BikeException(404, "Bike is not found");
    }

    @Override
    public BikeDto save(BikeDto bikeDto) {
        BikeEntity bikeentity = bikeMapper.toEntity(bikeDto);
        BikeEntity save = bikeRepo.save(bikeentity);
        return bikeMapper.toDto(save);
    }

    @Override
    @Transactional
    public BikeDto update(UUID id, BikeDto bikeDto) {
        BikeEntity bikeEntity = bikeMapper.toEntity(bikeDto);
        Optional<BikeEntity> bikeByIdOpt = bikeRepo.findById(id);
        if (bikeByIdOpt.isEmpty()){
            throw new BikeException(404, "Bike not found");
        }
        var exist = bikeByIdOpt.get();
        bikeMapper.update(exist, bikeEntity);
        return bikeMapper.toDto(exist);
    }

    @Override
    public void delete(UUID id) {
        bikeRepo.findById(id).ifPresentOrElse(bikeRepo::delete, () -> {
            throw new BikeException(404, "Bike not found");
        } );
    }

    @Override
    public List<BikeDto> findByManufacturer(String manufacturer) {
        List<BikeEntity> byManufacturer = bikeRepo.findByManufacturerAndRentedFalse(manufacturer);
        if (byManufacturer.isEmpty()){
            throw new BikeException(404, "Bike not found");
        }
        return bikeMapper.toDtos(byManufacturer);
    }

    @Override
    public List<BikeDto> findByType(TypeOfBike type) {
        List<BikeEntity> byType = bikeRepo.findByTypeAndRentedFalse(type);
        if (byType.isEmpty()){
            throw new BikeException(404, "Bike not found");
        }
        return bikeMapper.toDtos(byType);
    }
}
