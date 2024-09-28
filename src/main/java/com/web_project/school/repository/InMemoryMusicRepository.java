//package com.web_project.school.repository;
//
//import com.web_project.school.model.CarModel;
//import com.web_project.school.model.MusicModel;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//@Repository
//public class InMemoryMusicRepository {
//    private List<MusicModel> musics = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//
//    public List<MusicModel> findAllMusic() {
//        return new ArrayList<>(musics);
//
//    }
//
//    public MusicModel addMusic(MusicModel music) {
//        music.setId(idCounter.getAndIncrement());
//        musics.add(music);
//        return music;
//    }
//
//    public MusicModel updateMusic(MusicModel music) {
//        for (int i = 0; i < musics.size(); i++) {
//            if (musics.get(i).getId() == music.getId()){
//                musics.set(i, music);
//                return music;
//            }
//        }
//        return null;
//    }
//
//
//
//    public void deleteMusic(int id){
//        musics.removeIf(music -> music.getId() == id);
//    }
//
//    public MusicModel findMusicById(int id){
//        return musics.stream().filter(music -> music.getId() == id).findFirst().orElse(null);
//    }
//}
