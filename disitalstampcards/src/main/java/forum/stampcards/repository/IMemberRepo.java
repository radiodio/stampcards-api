package forum.stampcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import forum.stampcards.entity.Member;

@Repository
public interface IMemberRepo extends JpaRepository<Member, String> {

}
