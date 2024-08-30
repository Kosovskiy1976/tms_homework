package by.cni.repository;

import by.cni.domain.BikeEntity;
import by.cni.domain.TypeOfBike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BikeRepository extends JpaRepository<BikeEntity, UUID> {

    List<BikeEntity> findByRentedFalse(PageRequest pageRequest);

    List<BikeEntity> findByManufacturerAndRentedFalse(String manufacturer);

    List<BikeEntity> findByTypeAndRentedFalse(TypeOfBike type);
}
