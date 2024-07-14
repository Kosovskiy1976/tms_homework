package by.cni.school.web;

import by.cni.school.domain.StudentEntity;
import by.cni.school.dto.StudentDto;
import by.cni.school.mapper.StudentMapper;
import by.cni.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student"
//        , //method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT}
)
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable(name = "id") UUID id) {
        return studentService.findById(id);
    }

    @PostMapping
    public StudentDto registry(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable(name = "id") UUID id, @RequestBody StudentDto studentDto){
        return studentService.update(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public StudentDto delete(@PathVariable(name = "id") UUID id){
        return studentService.delete(id);
    }

    @GetMapping("/all/{classnumber}")
    public List<StudentDto> getStudentByClassnumber(@PathVariable(name = "classnumber") Integer classnumber) {
        return studentService.findByClassnumber(classnumber);
    }

}
