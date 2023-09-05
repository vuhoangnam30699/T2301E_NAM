package jdbc2;

import java.util.List;

public interface ListDAO {
    List<User> listUsers();
    List<Post> listPosts(int userId);
    List<Reaction> listReactions(int postId, Type type);
    List<User> listReactedUsers(int userId);
}
