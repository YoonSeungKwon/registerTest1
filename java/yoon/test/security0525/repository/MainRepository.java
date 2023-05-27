package yoon.test.security0525.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yoon.test.security0525.domain.Member;

@Repository
public interface MainRepository extends JpaRepository<Member, Long> {
    Member findById(String id);
}
