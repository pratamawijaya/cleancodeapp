package models;

/**
 * Created by unsigned on 26/03/16.
 *
 * This is the Post class
 */
public class Post {
    int userId, id;
    String title, body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (userId != post.userId) return false;
        if (id != post.id) return false;
        if (!title.equals(post.title)) return false;
        return body.equals(post.body);

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + id;
        result = 31 * result + title.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}
