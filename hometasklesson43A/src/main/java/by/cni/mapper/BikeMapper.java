package by.cni.mapper;

import by.cni.domain.BikeEntity;
import by.cni.dto.BikeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    BikeDto toDto(BikeEntity bikeEntity);

    BikeEntity toEntity(BikeDto bikeDto);

    List<BikeDto> toDtos(List<BikeEntity> bikeEntities);

    void update(@MappingTarget BikeEntity target, BikeEntity source);


}
