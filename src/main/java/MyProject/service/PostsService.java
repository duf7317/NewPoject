package MyProject.service;

import MyProject.Controller.dto.PoststSaveRequestDto;
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
}
