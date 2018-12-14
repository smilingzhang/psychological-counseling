package com.listenning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SendServiceImpl {

	public void audioSend() {

	}

	public Map<String, List<String[]>> videoSend(Map<String, List<String[]>> videoAddress2messages,
			String videoChatAddress, String myName, String otherName, String message) {

		if (videoAddress2messages == null)
			videoAddress2messages = new HashMap<String, List<String[]>>();
		String[] m = { myName, otherName, message };
		List<String[]> messages = videoAddress2messages.get(videoChatAddress);
		if (messages == null) {
			messages = new ArrayList<String[]>();
			videoAddress2messages.put(videoChatAddress, messages);
		}
		messages.add(m);
		return videoAddress2messages;
		/*
		 * Map<String, List<String[]>> videoAddress2messages = (Map<String,
		 * List<String[]>>) application.getAttribute("videoAddress2messages");
		 * if(videoAddress2messages == null) videoAddress2messages = new HashMap<String,
		 * List<String[]>>(); String videoChatAddress = (String)
		 * session.getAttribute("videoChatAddress");
		 * 
		 * String[] m = {myName, otherName, message}; List<String[]> messages =
		 * videoAddress2messages.get(videoChatAddress); if(messages == null) { messages
		 * = new ArrayList<String[]>(); videoAddress2messages.put(videoChatAddress,
		 * messages); } messages.add(m);
		 */
	}

	public Map<String, List<String[]>> audioSend(Map<String, List<String[]>> audioAddress2messages,
			String audioChatAddress, String myName, String otherName, String message) {
		if (audioAddress2messages == null)
			audioAddress2messages = new HashMap<String, List<String[]>>();

		String[] m = { myName, otherName, message };
		List<String[]> messages = audioAddress2messages.get(audioChatAddress);
		if (messages == null) {
			messages = new ArrayList<String[]>();
			audioAddress2messages.put(audioChatAddress, messages);
		}
		messages.add(m);
		return audioAddress2messages;
	}
}