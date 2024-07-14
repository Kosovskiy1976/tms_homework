package by.cni.school.service;

import by.cni.school.domain.StudentEntity;
import by.cni.school.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(UUID id);

    StudentDto update(UUID id, StudentDto studentDto);

    StudentDto delete(UUID id);

    List<StudentDto> findByClassnumber(Integer classnumber);
}
