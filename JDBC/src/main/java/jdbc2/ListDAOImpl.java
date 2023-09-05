package jdbc2;

import lombok.SneakyThrows;

import java.sql.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDAOImpl implements ListDAO {
    @SneakyThrows
    @Override
    public List<User> listUsers() {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_nam");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Date dob = resultSet.getDate("dob");
            users.add(User.builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .dob(dob)
                    .build());
        }
        statement.close();
        return users;
    }

    @SneakyThrows
    @Override
    public List<Post> listPosts(int userId) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM post_nam WHERE user_id = ?");
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        List<Post> posts = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            ZonedDateTime publishedAt = ZonedDateTime.parse(resultSet.getString("published_at"));
            String content = resultSet.getString("content");
            posts.add(Post.builder()
                    .id(id)
                    .userId(userId)
                    .publishedAt(publishedAt)
                    .content(content)
                    .build());
        }
        statement.close();
        return posts;
    }

    @SneakyThrows
    @Override
    public List<Reaction> listReactions(int postId, Type type) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM reaction_nam WHERE post_id = ? AND (? IS NULL OR type = ?)"
        );
        String stringValueOfType = type == null ? null : type.getValue();
        statement.setInt(1, postId);
        statement.setString(2, stringValueOfType);
        statement.setString(3, stringValueOfType);
        ResultSet resultSet = statement.executeQuery();
        List<Reaction> reactions = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            Integer userId = resultSet.getInt("user_id");
            Type myType = Type.convert(resultSet.getString("type"));
            reactions.add(Reaction.builder()
                    .id(id)
                    .postId(postId)
                    .userId(userId)
                    .type(myType)
                    .build());
        }

        statement.close();
        return reactions;
    }

    @SneakyThrows
    @Override
    public List<User> listReactedUsers(int userId) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT u.id AS user_id, u.first_name, u.last_name, u.dob, p.id AS post_id, r.id AS reaction_id" +
                        " FROM user_nam u " +
                        "JOIN reaction_nam r ON u.id = r.post_id " +
                        "JOIN post_nam p ON r.post_id = p.id " +
                        "WHERE p.user_id = ? "
        );
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        Set<User> userSet = new HashSet<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("user_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Date dob = resultSet.getDate("dob");
            userSet.add(User.builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .dob(dob)
                    .build());
        }
        List<User> userList = new ArrayList<>(userSet);

        statement.close();
        return userList;
    }

}
