package model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import marytts.modules.synthesis.Voice;

/**
 * 
 * @author Nicholas Jacquet
 *		references:
 *		
 *		Text-To-Speech-Stuff:
 *			https://www.youtube.com/watch?v=OLKxBorVwk8
 * 		Clippboard-Stuff:	
 * 			https://www.youtube.com/watch?v=5zPdduzNONk
 * 		Foreach loops:
 * 			https://www.geeksforgeeks.org/for-each-loop-in-java/
 * 
 * 		Eclipse error:
 * 			The package marytts is accessible from more than one module
 * 		Solution:
 *  		adding the jars to the classpath instead of the module path.
 * 		Found at:			
 * 			https://github.com/LWJGL/lwjgl3/issues/341
 *
 */
public class Main {
	public static void main(String[] args) {
		TextToSpeech tts = new TextToSpeech();
		
		//This will print all of the available voices that we have added to the class path:
		Voice.getAvailableVoices().stream().forEach(System.out::println);
		
		/*
		try {
			printClipboard();
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		tts.setVoice("dfki-poppy-hsmm");
		/*
		tts.speak(
				"Hello World!",
				1.0f, 
				false, 
				false
		);
		*/
		
		/*
		tts.speak(
				getClipBoardText(),
				1.0f, 
				false, 
				false
		);
		*/
		
		readLinesFromFile(tts, "/home/nicholas/Desktop/java-projects/text-files/js-page7.txt");
		
		/*
		tts.setVoice("cmu-slt-hsmm");
		tts.speak("Hello World!", 1.0f, false, false);
		tts.setVoice("cmu-rms-hsmm");
		tts.speak("Hello World!", 1.0f, false, false);
		*/
	}

	
	public static void readLinesFromFile(TextToSpeech tts, String filepath) {
		List<String> lines = readFileInList(filepath);
		for (String line : lines) {
			System.out.println(line);
			tts.speak(	line,	1.0f, false, false);
		}		
	}
	
	/* Thank you Ryan Scott! */
	public static List<String> readFileInList(String fileName) { 
        List<String> lines = Collections.emptyList();
     try { 
         lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
     } catch (IOException e) { 
        e.printStackTrace(); 
     } return lines; 
    }
	
	
	
	
	public static String getClipBoardText() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String text;
		try {
			text = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
			return text;
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
			return "could not access clipboard text";
		} catch (IOException e) {
			e.printStackTrace();
			return "could not access clipboard text";
		}
		
	}
	
	public static void printClipboard() throws UnsupportedFlavorException, IOException {
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		String paste = (String) c.getContents(null).getTransferData(DataFlavor.stringFlavor);
		
		System.out.println(paste);
	}
}
