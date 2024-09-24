package homework.forum.dao;

import homework.forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForumImpl implements Forum {
    private static final int INITIAL_CAPACITY = 10;
    private Post[] posts = new Post[INITIAL_CAPACITY];
    private int size;

    private Comparator<Post> comparator = (p1, p2) -> {
        int res = p1.getAuthor().compareTo(p2.getAuthor());
        res = res != 0 ? res : p1.getDate().compareTo(p2.getDate());
        return res != 0 ? res : Integer.compare(p1.getPostId(), p2.getPostId());
    };

    @Override
    public boolean addPost(Post post) {
        if (post == null || getPostById(post.getPostId()) != null) {
            return false;
        }
        if (size == posts.length) {
            posts = Arrays.copyOf(posts, posts.length + 1);
        }
        int index = Arrays.binarySearch(posts, 0, size, post, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(posts, index, posts, index + 1, size - index);
        posts[index] = post;
        size++;
        return true;
    }

    @Override
    public boolean removePost(int postId) {
        for (int i = 0; i < size; i++) {
            if (postId == posts[i].getPostId()) {
                System.arraycopy(posts, i + 1, posts, i, size - i - 1);
                posts[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
    Post post = getPostById(postId);
    if (post== null)
        return false;
    else {
        post.setContent(content);
        return true;
    }

    }

    @Override
    public Post getPostById(int postId) {
        for (int i = 0; i < size; i++) {
            if (postId == posts[i].getPostId()) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostsByAuthor(String author) {
        Post pattern = new Post(Integer.MIN_VALUE,null,author,null);
        pattern.setDate(LocalDateTime.MIN);
        int from = - Arrays.binarySearch(posts,0,size,pattern,comparator) - 1;
        pattern = new Post(Integer.MAX_VALUE,null,author,null);
        pattern.setDate(LocalDateTime.MAX);
        int to = - Arrays.binarySearch(posts,0,size,pattern,comparator) - 1;
        return Arrays.copyOfRange(posts,from,to);
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post pattern = new Post(Integer.MIN_VALUE, null, author, null);
        pattern.setDate(dateFrom.atStartOfDay());
        int from = -Arrays.binarySearch(posts, 0, size, pattern, comparator) - 1;
        pattern = new Post(Integer.MAX_VALUE, null, author, null);
        pattern.setDate(LocalDateTime.of(dateTo, LocalTime.MAX));
        int to = -Arrays.binarySearch(posts, 0, size, pattern, comparator) - 1;
        return Arrays.copyOfRange(posts, from, to);
    }

    @Override
    public int size() {
        return size;
    }
}

