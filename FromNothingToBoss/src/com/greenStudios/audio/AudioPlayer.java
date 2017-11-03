package com.greenStudios.audio;

import javax.sound.sampled.*;

public class AudioPlayer {
	
	private Clip clip;
	
	private FloatControl gainControl;
	
	public AudioPlayer(String s) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), 
														baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play(float volume) {
		if(clip == null) {
			return;
		}
		stop();
		gainControl.setValue(volume);
		clip.setFramePosition(0);
		clip.start();
		}
	
	public void play() {
		if(clip == null) {
			return;
		}
		stop();
		clip.setFramePosition(0);
		clip.start();
		}
	
	public void loop(float volume) {
		if(clip == null) {
			return;
		}
		stop();
		gainControl.setValue(volume);
		clip.setFramePosition(0);
		clip.setLoopPoints(0, -1);
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	
	public void loop() {
		if(clip == null) {
			return;
		}
		stop();
		clip.setFramePosition(0);
		clip.setLoopPoints(0, -1);
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		if(clip.isRunning()) {
			clip.stop();
		}
	}
	
	public void close() {
		stop();
		clip.close();
	}
}
