package org.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private Long id;
    private Long userId;
    private NotificationType type;
    private Boolean isRead;
    private ZonedDateTime createdAt;
    private Boolean isDeleted;
    private Long objectId;
    private ObjectType objectType;
    private Long contentId;
    private ContentType contentType;
    private String content;
    private String displayContent;

}
