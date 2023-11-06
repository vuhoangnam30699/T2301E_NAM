package fpt;

import org.apache.commons.text.StringSubstitutor;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(100L, "Khoi", "https://www.thedesignwork.com/wp-content/uploads/2011/10/Random-Pictures-of-Conceptual-and-Creative-Ideas-02.jpg"),
                new User(101L, "Mark", "https://clipart-library.com/data_images/6103.png"),
                new User(102L, "Bill", "https://clipart-library.com/data_images/6106.png"),
                new User(103L, "Alex", "https://clipart-library.com/data_images/6108.png"),
                new User(104L, "Bob", "https://clipart-library.com/data_images/6109.png")
        );
        List<Page> pages = List.of(
                new Page(1000L, "Hanoi pho", "https://clipart-library.com/data_images/6110.png", "Vietnam"),
                new Page(1001L, "Beatvn", "https://clipart-library.com/data_images/6115.png", "My dinh")
        );

        List<Post> posts = List.of(
                new Post(122L, "Troi hom nay dep qua", "https://clipart-library.com/new_gallery/clipart-2023/clipart-2023-6.webp"),
                new Post(123L, "Em om hai thang nay roi", "https://clipart-library.com/data_images/6142.jpg"),
                new Post(124L, "Sky oii", "https://clipart-library.com/data_images/6145.png")
        );

        List<NotificationTemplate> notificationTemplates = List.of(
                new NotificationTemplate(1L, "${object.name} has 1 new view at ${object.address} avatar: ${object.avatar}", "en", "PAGE_NEW_VIEW"),
                new NotificationTemplate(2L, "${object.name} có 1 lượt xem mới ở ${object.address} ảnh đại diện: ${object.avatar}", "vi", "PAGE_NEW_VIEW"),
                new NotificationTemplate(3L, "${object.name} posted a new video: \"${content.content}\"", "en", "USER_NEW_VIDEO"),
                new NotificationTemplate(4L, "${object.name} đã đăng một video mới: \"${content.content}\"", "vi", "USER_NEW_VIDEO")

        );

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
                        .contentId(1001L)
                        .contentType(ContentType.PAGE)
                        .templateCode("PAGE_NEW_VIEW")
                        .build(),
                Notification.builder()
                        .id(1L)
                        .userId(100L)
                        .type(NotificationType.VIDEO)
                        .isRead(true)
                        .createdAt(ZonedDateTime.now())
                        .isDeleted(false)
                        .objectId(101L)
                        .objectType(ObjectType.USER)
                        .contentId(123L)
                        .contentType(ContentType.POST)
                        .templateCode("USER_NEW_VIDEO")
                        .build()
        );

        String language = "vi";
        for (Notification notification : notifications) {
            NotificationTemplate template = notificationTemplates.stream()
                    .filter(t -> t.getCode()
                            .equals(notification.getTemplateCode()) && t.getLanguage().equals(language)
                            ).findFirst().orElseThrow(() -> new RuntimeException("Not found"));

            Map<String, Object> substitutors = new HashMap<>();
            if (notification.getObjectType().equals(ObjectType.USER)) {
                User user = users.stream().filter(u -> u.getId() == notification.getObjectId()).findFirst().orElseThrow(() -> new RuntimeException("Object not found"));
                substitutors.put("object.name", user.getName());
                substitutors.put("object.avatar", user.getAvatar());
            } else if (notification.getObjectType().equals(ObjectType.PAGE)) {
                Page page = pages.stream().filter(p -> p.getId() == notification.getObjectId()).findFirst().orElseThrow(() -> new RuntimeException("Object not found"));
                substitutors.put("object.name", page.getName());
                substitutors.put("object.avatar", page.getAvatar());
                substitutors.put("object.address", page.getAddress());
            }

            if (notification.getContentType().equals(ContentType.POST)) {
                Post post = posts.stream().filter(p -> p.getId() == notification.getContentId()).findFirst().orElseThrow(() -> new RuntimeException("Content not found"));
                substitutors.put("content.content", post.getContent());
                substitutors.put("content.image", post.getImage());
            } else if (notification.getContentType().equals(ContentType.PAGE)) {
                Page page = pages.stream().filter(p -> p.getId() == notification.getContentId()).findFirst().orElseThrow(() -> new RuntimeException("Content not found"));
                substitutors.put("content.name", page.getName());
                substitutors.put("content.avatar", page.getAvatar());
                substitutors.put("content.address", page.getAddress());
            }

            String displayContent = StringSubstitutor.replace(template.getContent(), substitutors);

            System.out.println(displayContent);

        }
    }
}
