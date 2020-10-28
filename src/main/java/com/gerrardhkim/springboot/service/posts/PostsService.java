package com.gerrardhkim.springboot.service.posts;

import com.gerrardhkim.springboot.domain.posts.Posts;
import com.gerrardhkim.springboot.domain.posts.PostsRepository;
import com.gerrardhkim.springboot.web.dto.PostsResponseDto;
import com.gerrardhkim.springboot.web.dto.PostsSaveRequestDto;
import com.gerrardhkim.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data for the id. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data for the id. id="+id));

        return new PostsResponseDto(entity);
    }
}
