package com.company.reccolldao.dao;

import com.company.reccolldao.model.Album;
import org.apache.el.parser.JJTELParserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {
    private static final String INSERT_ALBUM_SQL =
            "insert into album ( title, artistId, releaseDate, labelId, listPrice) values (?, ?, ?, ?, ?)";

    private static final String SELECT_ALBUM_SQL =
            "select * from album where id = ?";

    private static final String SELECT_ALL_ALBUMS_SQL =
            "select * from album";

    private static final String DELETE_ALBUM_SQL =
            "delete from album where id = ?";

    private static final String UPDATE_ALBUM_SQL =
            "update album set  title = ?, artistId = ?, releaseDate = ?, labelId = ? , listPrice= ?,where id = ?";

    private static final String SELECT_ALBUMS_BY_TITLE_SQL =
            "select * from album where make = ?";

    private static final String SELECT_ALBUM_BY_ARTISTID_SQL =
            "select * from album where artistId = ?";

    private JdbcTemplate jdbcTemplate;

    //constructor injection
    @Autowired
    public AlbumDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public Album addAlbum(Album album) {
        jdbcTemplate.update(INSERT_ALBUM_SQL,
                album.getArtistId(),
                album.getLabelId(),
                album.getListPrice(),
                album.getReleaseDate(),
                album.getTitle());

        int id= jdbcTemplate.queryForObject("select last _insert_id()", Integer.class);
        album.setId(id);

        return album;
    }

    @Override
    public Album getAlbum(int id) {

        try {
            return  jdbcTemplate.queryForObject(SELECT_ALBUM_SQL, )
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        return null;
    }

    @Override
    public void updateAlbum(Album album) {

    }

    @Override
    public void deleteAlbum(int id) {
        jdbcTemplate.update(DELETE_ALBUM_SQL,id);

    }
}
