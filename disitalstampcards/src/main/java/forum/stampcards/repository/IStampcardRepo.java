package forum.stampcards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import forum.stampcards.entity.Stampcard;

@Repository
public interface IStampcardRepo extends JpaRepository<Stampcard, Long> {

	List<Stampcard> findByEmployeeIdOrderByStampNumberAscStampDateAsc(String employeeId);

	List<Stampcard> findFirstByEmployeeIdAndStampNumberOrderByStampDateDesc(String employeeId, Integer stampNum);

}
