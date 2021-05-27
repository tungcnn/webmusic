package com.webmusic.repository;

import com.webmusic.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Query(value = "select * from Playlist where user_id = ?1",nativeQuery = true)
    List<Playlist> findPlaylistByUserId(Long id);
    List<Playlist> findByNameContains(String name);
    @Query(value = "select * from Playlist order by views desc limit 15" , nativeQuery = true)
    List<Playlist> top15Views();
    @Query(value = "select * from Playlist order by like_total desc limit 15" , nativeQuery = true)
    List<Playlist> top15Like();
}
