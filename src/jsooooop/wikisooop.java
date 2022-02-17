package jsooooop;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class wikisooop {
	public static void main(String[] args) {
		String src = "https://en.wikipedia.org/wiki/Horse";
		Document doc;
		try {
			doc = fetch(src);
			System.out.println(doc);
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public static Document fetch(String s) throws IOException {
		return Jsoup.connect(s).get();
	}
}
