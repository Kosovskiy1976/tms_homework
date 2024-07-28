package by.cni.school.service.Impl;

import by.cni.school.domain.StudentEntity;
import by.cni.school.dto.StudentDto;
import by.cni.school.mapper.StudentMapper;
import by.cni.school.repositopy.StudentRepository;
import by.cni.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.studentDtoToStudentEntity(studentDto);
        StudentEntity save = studentRepository.save(studentEntity);
        return studentMapper.studentEntityToStudentDto(save);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentMapper.studentEntityListToStudentDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto findById(UUID id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);

        if (byId.isPresent()) {
            return studentMapper.studentEntityToStudentDto(byId.get());
        }
        return null;
    }
    @Transactional
    @Override
    public StudentDto update(UUID id, StudentDto studentDto) {
        Optional<StudentEntity> byId = studentRepository.findById(id);

        if (byId.isPresent()){
            StudentEntity studentEntityTarget = byId.get();
            StudentEntity studentEntitySource = studentMapper.studentDtoToStudentEntity(studentDto);
            studentMapper.update(studentEntityTarget, studentEntitySource);
            return studentMapper.studentEntityToStudentDto(studentEntityTarget);
        }
        return null;
    }

    @Override
    public StudentDto delete(UUID id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId.isPresent()){
            studentRepository.delete(byId.get());
            return studentMapper.studentEntityToStudentDto(byId.get());
        }
        return null;
    }

    @Override
    public List<StudentDto> findByClassnumber(Integer classnumber) {
        List<StudentEntity> byClassnumber = studentRepository.findByClassnumber(classnumber);
        return studentMapper.studentEntityListToStudentDtoList(byClassnumber);
    }
}
