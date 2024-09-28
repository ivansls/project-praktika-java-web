package com.web_project.school.service;

import com.web_project.school.model.MusicModel;
import com.web_project.school.repository.MusicRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InMemoryMusicServiceImpl implements MusicService{
    private final MusicRepository musicRepository;

    public InMemoryMusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<MusicModel> findAllMusic() {
        return musicRepository.findAll(Sort.by("id"));
    }

    @Override
    public MusicModel addMusic(MusicModel music) {
        return musicRepository.save(music);
    }

    @Override
    public MusicModel updateMusic(MusicModel music) {
        return musicRepository.save(music);
    }

    @Override
    public void deleteMusic(Long id) {
         musicRepository.deleteById(id);
    }

    @Override
    public MusicModel findMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public List<MusicModel> MusicSort(String author) {
        return musicRepository.findAll(Sort.by("id")).stream()
                .filter(music -> Objects.equals(music.getAuthor(), author))
                .collect(Collectors.toList());

    }

    @Override
    public List<MusicModel> musicSortAlbum(String album) {
        return musicRepository.findAll(Sort.by("id")).stream()
                .filter(music -> Objects.equals(music.getAlbum(), album))
                .collect(Collectors.toList());

    }
}
