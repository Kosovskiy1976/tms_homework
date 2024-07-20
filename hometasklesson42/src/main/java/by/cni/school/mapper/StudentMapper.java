package by.cni.school.mapper;

import by.cni.school.domain.StudentEntity;
import by.cni.school.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity studentDtoToStudentEntity(StudentDto dto);

    StudentDto studentEntityToStudentDto(StudentEntity entity);

    List<StudentDto> studentEntityListToStudentDtoList(List<StudentEntity> entities);

    List<StudentEntity> studentDtoListToStudentEntityList(List<StudentDto> dtos);

    void update(@MappingTarget StudentEntity studentEntityTarget, StudentEntity studentEntitySource);
}
