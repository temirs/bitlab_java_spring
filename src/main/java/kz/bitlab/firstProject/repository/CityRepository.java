package kz.bitlab.firstProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.firstProject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {
}
