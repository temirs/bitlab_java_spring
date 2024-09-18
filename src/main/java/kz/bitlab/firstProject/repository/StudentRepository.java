package kz.bitlab.firstProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT st FROM Student st "+
    "WHERE st.name ilike concat('%', :search, '%') " +
    "OR st.surname ilike concat('%',  :search, '%') ")
    List<Student> getAllStudentsByWord(String search);

}
