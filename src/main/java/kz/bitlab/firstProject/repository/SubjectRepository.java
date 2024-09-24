package kz.bitlab.firstProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.firstProject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
}
