package classwork.album.dao;

import classwork.album.model.Photo;

import java.time.LocalDate;

public interface Album {

    boolean addPhoto(Photo photo);

    boolean removePhoto(int photoID,int albumID);

    boolean updatePhoto(int photoID,int albumID,String url);

    Photo getPhotoFromAlbum(int photoID,int albumID);

    Photo[] getAllPhotoFromAlbum(int albumID);

    Photo[] getPhotosBetweenDate(LocalDate dateFrom,LocalDate dateTo);
    int size();
}
