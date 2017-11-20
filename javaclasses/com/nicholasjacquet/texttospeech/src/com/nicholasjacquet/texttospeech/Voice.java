package com.nicholasjacquet.texttospeech;

import com.sun.speech.freetts.VoiceManager;

public class Voice 
{
	private String name; // the name of the voice that we want to use
	
	private com.sun.speech.freetts.Voice voice; //
	
	public Voice(String name)
	{
		this.name = name;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();
	}
	
	public void say(String something)
	{
		this.voice.speak(something);
	}
}
