package com.arx.seeker.savior.steps;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class Connector {
	public static Document customConnect(String url){
		Document document= null;
			try {
				Thread.sleep(500);
				document= Jsoup.connect(url).get();
			} catch (InterruptedException|IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return document;
	}
}
