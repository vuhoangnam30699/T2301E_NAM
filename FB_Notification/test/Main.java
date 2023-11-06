package org.test;

import org.apache.commons.text.StringSubstitutor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Notification> notifications = List.of(
                Notification.builder()
                        .id(1L)
                        .userId(100L)
                        .type(NotificationType.PAGE)
                        .isRead(false)
                        .createdAt(ZonedDateTime.now())
                        .isDeleted(false)
                        .objectId(1000L)
                        .objectType(ObjectType.PAGE)
                        .contentId(null)
                        .contentType(ContentType.PAGE)
                        .content("${object.name} has 1 new view")
                        .build(),
                Notification.builder()
                        .id(1L)
                        .userId(100L)
                        .type(NotificationType.VIDEO)
                        .isRead(true)
                        .createdAt(ZonedDateTime.now())
                        .isDeleted(false)
                        .objectId(1000L)
                        .objectType(ObjectType.USER)
                        .contentId(123L)
                        .contentType(ContentType.POST)
                        .content("${object.name} posted a new video: ${object.content}")
                        .build()
        );

        String replace = StringSubstitutor.replace(
                "${objectName} has 1 new post",
                Map.of("objectName", "Khoi")
        );

        System.out.println(replace);


    }
}
