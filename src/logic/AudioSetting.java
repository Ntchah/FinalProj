package logic;

import javafx.scene.media.MediaPlayer;
import java.util.*;
import javafx.util.Duration;
import resource.AudioManager;
import resource.AudioManager.Audios;
import utility.Configuration;
import javafx.scene.media.Media;

public class AudioSetting {

	private static final Map<String, Integer> SONG_NAME = new HashMap<>(Map.of("Default", 0, "Equal Exchange", 1, "Space", 2,
			"Usamaro", 3, "Limitless", 4, "Bounce", 5, "Adventure", 6, "Timekeeper", 7, "Risk", 8));
	private static final Map<Integer, String> SONG_NUMBER = new HashMap<>(Map.of(0, "Default", 1, "Equal Exchange", 2,
			"Space", 3, "Usamaro", 4, "Limitless", 5, "Bounce", 6, "Adventure", 7, "Timekeeper", 8, "Risk"));
	private static final Media[][] SONG_SETS = {
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC), AudioManager.getSong(Audios.INGAME_SONG) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC2), AudioManager.getSong(Audios.INGAME_SONG2) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC3), AudioManager.getSong(Audios.INGAME_SONG3) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC4), AudioManager.getSong(Audios.INGAME_SONG4) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC5), AudioManager.getSong(Audios.INGAME_SONG5) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC6), AudioManager.getSong(Audios.INGAME_SONG6) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC7), AudioManager.getSong(Audios.INGAME_SONG7) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC8), AudioManager.getSong(Audios.INGAME_SONG8) },
			{ AudioManager.getSong(Audios.MAIN_MENU_MUSIC9), AudioManager.getSong(Audios.INGAME_SONG9) },};
	private static int music = 0;
	private static int state = 0;
	private static Media currentSong = SONG_SETS[music][state];
	private static MediaPlayer mediaPlayer = new MediaPlayer(currentSong);

	public static void playMedia() {

		getMediaPlayer().setVolume(Configuration.soundVolume);
		mediaPlayer.setOnEndOfMedia(() -> {

			resetMedia();

		});
		mediaPlayer.play();

	}

	public static void pauseMedia() {

		mediaPlayer.pause();

	}

	public static void resetMedia() {

		mediaPlayer.seek(Duration.seconds(0));

	}

	public static void nextSong() {

		mediaPlayer.stop();
		mediaPlayer = new MediaPlayer(currentSong);
		playMedia();

	}

	public static void setMusic(int music) {

		AudioSetting.music = music;
		currentSong = SONG_SETS[music][state];

	}

	public static void setState(int state) {

		AudioSetting.state = state;
		currentSong = SONG_SETS[music][state];

	}

	public static Map<String, Integer> getSongname() {
		return SONG_NAME;
	}

	public static Map<Integer, String> getSongnumber() {
		return SONG_NUMBER;
	}

	public static int getMusic() {
		return music;
	}

	public static MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

}
