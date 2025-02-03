package springbootawsbook.springawsbook.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    //SpringDataJPA에서 제공하지 않는 메소드 -> 쿼리로 작성
    //Query는 가독성이 좋음
}
