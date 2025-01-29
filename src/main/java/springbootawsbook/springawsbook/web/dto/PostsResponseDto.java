package springbootawsbook.springawsbook.web.dto;


import springbootawsbook.springawsbook.domain.posts.Posts;

public class PostsResponseDto {

    private Long id;
    private String title;
    private String author;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
    }
    //PostsResponseDto는 Entity의 필드 중 일부만 사용한다.
    //생성자로 Entity를 받아 필드에 값을 넣는다.
    //굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 Entity를 받아 처리한다.
}
