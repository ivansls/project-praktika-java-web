package com.web_project.school.service;

import com.web_project.school.model.CarModel;
import com.web_project.school.model.MusicModel;

import java.util.List;

public interface MusicService {
    public List<MusicModel> findAllMusic();
    public MusicModel addMusic(MusicModel music);
    public MusicModel updateMusic(MusicModel music);
    public void deleteMusic(int id);
    public MusicModel findMusicById(int id);


    List<MusicModel> MusicSort(String author);
    List<MusicModel> musicSortAlbum(String author);
}
