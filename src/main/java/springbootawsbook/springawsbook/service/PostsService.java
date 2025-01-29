package springbootawsbook.springawsbook.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootawsbook.springawsbook.domain.posts.Posts;
import springbootawsbook.springawsbook.domain.posts.PostsRepository;import springbootawsbook.springawsbook.web.dto.PostsResponseDto;

import springbootawsbook.springawsbook.web.dto.PostsSaveRequestDto;
import springbootawsbook.springawsbook.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //추가
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
        //현재 update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없다.
        //이유 : JPA의 영속성 컨텍스트 때문이다.
        //영속성 컨텍스트 : 엔티티를 영구 저장하는 환경
        //JPA의 핵심은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈린다
    }
}
