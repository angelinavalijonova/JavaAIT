package classwork.album.dao;

import classwork.album.model.Photo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumImpl implements Album {

   private Photo[] photos;
   private int size;

    public AlbumImpl(int capacity) {
        this.photos = new Photo[capacity];
    }
    // comparator sort first by albumId then by photoId
    Comparator<Photo> comparator = (p1, p2) -> {
        int res = Integer.compare(p2.getAlbumID(), p2.getAlbumID());
        return res != 0 ? res : Integer.compare(p1.getPhotoID(), p2.getPhotoID());
    };


    @Override
    public boolean addPhoto(Photo photo) {
        if(photo == null || size== photos.length|| getPhotoFromAlbum(photo.getPhotoID(),photo.getAlbumID()) != null){
            return false;
        }
        int index = Arrays.binarySearch(photos,0,size,photo,comparator);
        index = index >= 0 ? index : - index - 1;
        System.arraycopy(photos,index,photos,index+1,size-index);
        photos[index] = photo;
        size++;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if(photos[i].getPhotoID() == photoId && photos[i].getAlbumID() == albumId){
                System.arraycopy(photos, i + 1, photos, i , size - i - 1);
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoID, int albumID, String url) {
       Photo photo = getPhotoFromAlbum(albumID,photoID);
        if (photo==null){
            return false;
        }
        photo.setUrl(url);
        return true;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoID, int albumID) {
        for (int i = 0; i < size; i++) {
            if(photos[i].getAlbumID()==albumID && photos[i].getPhotoID()==photoID){
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumID) {
        return findPhotosByPredicate(p -> p.getAlbumID() == albumID);
    }


    @Override
    public Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return findPhotosByPredicate(p -> p.getDate().toLocalDate().isAfter(dateFrom.minusDays(1)) && p.getDate().toLocalDate().isBefore(dateTo.plusDays(1)));
    }

    @Override
    public int size() {
        return size;
    }
    private Photo[] findPhotosByPredicate(Predicate<Photo> predicate) {
        Photo[] res = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                res[j++] = photos[i];
            }
        }
        return Arrays.copyOf(res, j);
    }

}
