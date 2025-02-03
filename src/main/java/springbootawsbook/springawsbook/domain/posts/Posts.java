package springbootawsbook.springawsbook.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springbootawsbook.springawsbook.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Entity //JPA 어노테이션
//테이블과 링크될 클래스
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블이름을 매칭한다.
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;
    //테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    //사용하는 이유 : 기본 값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    //문자열의 경우 VARCHAR(255)가 기본 값이지만, 사이즈를 500으로 늘리고 싶거나 (ex: title),
    // 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용된다.

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //추가
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
