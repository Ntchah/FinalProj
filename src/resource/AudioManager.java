package resource;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class AudioManager {

	private static Map<Audios, AudioClip> soundEffectResources = new HashMap<Audios, AudioClip>();
	private static Map<Audios, Media> songResources = new HashMap<Audios, Media>();

	public enum Audios {

		BALLOON_POPPED, MAIN_MENU_MUSIC, MAIN_MENU_MUSIC2, MAIN_MENU_MUSIC3, MAIN_MENU_MUSIC4, MAIN_MENU_MUSIC5,
		MAIN_MENU_MUSIC6, MAIN_MENU_MUSIC7, MAIN_MENU_MUSIC8, MAIN_MENU_MUSIC9, BUTTON_CLICKED, INGAME_SONG,
		INGAME_SONG2, INGAME_SONG3, INGAME_SONG4, INGAME_SONG5, INGAME_SONG6, INGAME_SONG7, INGAME_SONG8, INGAME_SONG9

	}

	static {

		loadAudio();
		System.out.println("Audios have successfully been loaded");

	}

	private static AudioClip getAudio(String path) {

		return new AudioClip(ClassLoader.getSystemResource(path).toString());

	}

	private static Media getSong(String path) {

		return new Media(ClassLoader.getSystemResource(path).toString());
	}

	public static void loadAudio() {

		soundEffectResources.put(Audios.BALLOON_POPPED, getAudio("audio/balloon_popped.wav"));
		soundEffectResources.put(Audios.BUTTON_CLICKED, getAudio("audio/button_clicked.wav"));
		songResources.put(Audios.MAIN_MENU_MUSIC, getSong("audio/mainmenu.mp3"));
		songResources.put(Audios.INGAME_SONG, getSong("audio/main.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC2, getSong("audio/period.mp3"));
		songResources.put(Audios.INGAME_SONG2, getSong("audio/brother.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC3, getSong("audio/everything-feels-new.mp3"));
		songResources.put(Audios.INGAME_SONG3, getSong("audio/space-atmospheric-background.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC4, getSong("audio/usamaro.mp3"));
		songResources.put(Audios.INGAME_SONG4, getSong("audio/braveheart.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC5, getSong("audio/limitless.mp3"));
		songResources.put(Audios.INGAME_SONG5, getSong("audio/legend_sword.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC6, getSong("audio/MotionElements_8-bit-children-game-short.wav"));
		songResources.put(Audios.INGAME_SONG6, getSong("audio/risk.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC7, getSong("audio/adventure.mp3"));
		songResources.put(Audios.INGAME_SONG7, getSong("audio/elven_kingdom.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC8, getSong("audio/jj_lin_timekeeper.mp3"));
		songResources.put(Audios.INGAME_SONG8, getSong("audio/jj_lin_2.mp3"));
		songResources.put(Audios.MAIN_MENU_MUSIC9, getSong("audio/bounce.mp3"));
		songResources.put(Audios.INGAME_SONG9, getSong("audio/stomping-rock-four-shots.mp3"));

	}

	public static AudioClip getSoundTrack(Audios audio) {

		return soundEffectResources.get(audio);

	}

	public static Media getSong(Audios audio) {

		return songResources.get(audio);

	}

}
