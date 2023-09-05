package jdbc2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListDAO list = new ListDAOImpl();
        List<User> user = list.listUsers();
        List<Post> post = list.listPosts(1);
        List<Reaction> reaction = list.listReactions(1, Type.DISLIKE);
        List<User> reactedUser = list.listReactedUsers(1);
    }
}
