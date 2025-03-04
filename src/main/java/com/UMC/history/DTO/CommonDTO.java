package com.UMC.history.DTO;

import com.UMC.history.util.CategoryEnum;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class CommonDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Post{
        private String userId;
        private CategoryEnum category;
        private String title;
        private String contents;
        private String hashTags; //임시 추가
        private List<MultipartFile> imageList;

        public Post(){}
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class LockPost{
        private String title;
        private String contents;

        public LockPost(){}
    }

    public interface UserProtected{
        Long getPostIdx();
        UserEntity getUser();
        CategoryEnum getCategory();
        String getTitle();
        String getContents();
        int getTotalClick();
        int getTotalLike();
        int getTotalComment();
        LocalDateTime getCreatedDate();
        LocalDateTime getLastModifedDate();

        interface UserEntity{
            String getUserId();
            String getNickName();
            String getProfileImgUrl();
        }
    }

    public interface LikeUserProtected{
        Long getLikeIdx();
        UserProtected getPost();
        LocalDateTime getCreatedDate();
        LocalDateTime getLastModifedDate();
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Comment{
        private String contents;
        public Comment(){}
    }
}
