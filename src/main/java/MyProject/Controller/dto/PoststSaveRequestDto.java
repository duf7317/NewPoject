package MyProject.Controller.dto;

import MyProject.domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PoststSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PoststSaveRequestDto(String title, String content, String author){

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
