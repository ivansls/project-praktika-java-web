package com.web_project.school.service;

import com.web_project.school.model.MusicModel;
import com.web_project.school.repository.InMemoryMusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InMemoryMusicServiceImpl implements MusicService{
    private final InMemoryMusicRepository musicRepository;

    public InMemoryMusicServiceImpl(InMemoryMusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<MusicModel> findAllMusic() {
        return musicRepository.findAllMusic();
    }

    @Override
    public MusicModel addMusic(MusicModel music) {
        return musicRepository.addMusic(music);
    }

    @Override
    public MusicModel updateMusic(MusicModel music) {
        return musicRepository.updateMusic(music);
    }

    @Override
    public void deleteMusic(int id) {
         musicRepository.deleteMusic(id);
    }

    @Override
    public MusicModel findMusicById(int id) {
        return musicRepository.findMusicById(id);
    }

    @Override
    public List<MusicModel> MusicSort(String author) {
        return musicRepository.findAllMusic().stream()
                .filter(music -> Objects.equals(music.getAuthor(), author))
                .collect(Collectors.toList());

    }
}
