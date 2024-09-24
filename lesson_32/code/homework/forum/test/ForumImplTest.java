package homework.forum.test;

import homework.forum.dao.Forum;
import homework.forum.dao.ForumImpl;
import homework.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ForumImplTest {

    Forum forum;
    Post[] posts = new Post[6];
    Comparator<Post> comparator = (p1, p2) -> Integer.compare(p1.getPostId(), p2.getPostId());

    @BeforeEach
    void setUp() throws Exception{
        forum = new ForumImpl();
        posts[0] = new Post(0, "title1", "author1", "content");
        posts[1] = new Post(1, "title2", "author2", "content");
        posts[2] = new Post(2, "title3", "author2", "content");
        posts[3] = new Post(3, "title4", "author1", "content");
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }
    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertTrue(forum.addPost(new Post(4, "title4", "author4", "content")));
        assertEquals(5, forum.size());
        assertFalse(forum.addPost(posts[5]));
        assertEquals(5, forum.size());
    }


    @Test
    void removePost() {
        assertTrue(forum.removePost(2));
        assertEquals(3, forum.size());
        assertFalse(forum.removePost(2));
        assertEquals(3, forum.size());
    }


    @Test
    void updatePost() {
        assertTrue(forum.updatePost(3,"New content"));
        assertEquals("New content",forum.getPostById(3).getContent());
    }

    @Test
    void getPostById() {
        assertEquals(posts[2],forum.getPostById(2));
        assertNull(forum.getPostById(5));
    }

    @Test
    void getPostsByAuthor() {
        Post[] actual = forum.getPostsByAuthor("author1");
        Arrays.sort(actual,comparator);
        Post[] expected = {posts[0],posts[3]};
        assertArrayEquals(expected,actual);
    }

    @Test
    void testGetPostsByAuthorStringLocalDateLocalDate() {
        posts[0].setDate(LocalDateTime.now().minusDays(6));
        posts[1].setDate(LocalDateTime.now().minusDays(9));
        posts[2].setDate(LocalDateTime.now().minusDays(5));
        posts[3].setDate(LocalDateTime.now().minusDays(7));
        posts[4].setDate(LocalDateTime.now().minusDays(10));
        posts[5].setDate(LocalDateTime.now().minusDays(8));
        // FIXME
        // forum.addPost(posts[5]);
        forum = new ForumImpl();
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
        Post[] actual = forum.getPostsByAuthor("author1", LocalDate.now().minusDays(8), LocalDate.now().minusDays(7));
        Arrays.sort(actual, comparator);
        Post[] expected = {posts[3], posts[5]};
        assertArrayEquals(expected, actual);
        actual = forum.getPostsByAuthor("author1", LocalDate.now().minusDays(15), LocalDate.now().minusDays(10));
        assertEquals(0, actual.length);
    }


    @Test
    void size() {
    }
}