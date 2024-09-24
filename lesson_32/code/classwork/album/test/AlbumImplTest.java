package classwork.album.test;

import classwork.album.dao.Album;
import classwork.album.dao.AlbumImpl;
import classwork.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AlbumImplTest {
    Photo[] photos;
   int size;
   Album album; // object Album
   LocalDateTime now = LocalDateTime.now();

    // comparator sort first by albumId then by photoId
    Comparator<Photo> comparator = (p1,p2) -> {
        int res = Integer.compare(p2.getAlbumID(), p2.getAlbumID());
        return res != 0 ? res : Integer.compare(p1.getPhotoID(), p2.getPhotoID());
    };



    @BeforeEach
    void setUp() {
        // fill array of photos
        album = new AlbumImpl(7);
        photos = new Photo[6];
        photos[0] = new Photo(1, 1, "title1", "url1", now.minusDays(7));
        photos[1] = new Photo(1, 2, "title2", "url2", now.minusDays(7));
        photos[2] = new Photo(1, 3, "title3", "url3", now.minusDays(5));
        photos[3] = new Photo(2, 1, "title1", "url1", now.minusDays(7));
        photos[4] = new Photo(2, 4, "title4", "url4", now.minusDays(2));
        photos[5] = new Photo(1, 4, "title4", "url1", now.minusDays(2));

        for (int i = 0; i < photos.length; i++) {
            album.addPhoto(photos[i]);
        }

    }

    @Test
    void addPhoto() {
        assertFalse(album.addPhoto(null));
        assertFalse(album.addPhoto(photos[1]));// because we added existed
        Photo photo = new Photo(2,5,"title5","url5",now.minusDays(2));
        assertTrue(album.addPhoto(photo));
        assertEquals(7,album.size());
        photo = new Photo(2,6,"title6","url6",now.minusDays(2));
        assertFalse(album.addPhoto(photo));


    }

    @Test
    void removePhoto() {
        assertTrue(album.removePhoto(1,1));// remove existed photo
        assertFalse(album.removePhoto(1,7));// remove not existed photo
        assertEquals(5,album.size());

    }

    @Test
    void updatePhoto() {
    assertTrue(album.updatePhoto(1,1,"newUrl"));
    assertEquals("newUrl",album.getPhotoFromAlbum(1,1).getUrl());

    }

    @Test
    void getPhotoFromAlbum() {
    assertEquals(photos[0],album.getPhotoFromAlbum(1,1));//get existed code
    assertNull(album.getPhotoFromAlbum(5,1));
    }

    @Test
    void getAllPhotoFromAlbum() {
        Photo[] expected= {photos[3],photos[4]};
        Photo[] actual= album.getAllPhotoFromAlbum(2);
        assertArrayEquals(expected,actual);
    }

    @Test
    void getPhotosBetweenDate() {
        LocalDate localDate = LocalDate.now();
        Photo[] expected = {photos[2], photos[4], photos[5]};
        Arrays.sort(expected, comparator);
        Photo[] actual = album.getPhotosBetweenDate(localDate.minusDays(5), localDate.minusDays(2));
        Arrays.sort(actual, comparator);
       assertArrayEquals(expected,actual);
    }

    @Test
    void size(){
        assertEquals(6,album.size());
    }
}