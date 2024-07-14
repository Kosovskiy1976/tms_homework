package by.cni.school.repositopy;

import by.cni.school.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findByClassnumber(Integer classnumber);
}
