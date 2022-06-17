package MyProject.service;


import MyProject.Controller.PostsResponseDto;
import MyProject.Controller.PostsUpdateRequestDto;
import MyProject.Controller.dto.PoststSaveRequestDto;
import MyProject.domain.Posts.Posts;
import MyProject.domain.Posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PoststSaveRequestDto requestDto) {
        return  postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    public PostsResponseDto findById (Long id){
       Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

       return new PostsResponseDto(entity);
    }
}