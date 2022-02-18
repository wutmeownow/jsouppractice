package jsooooop;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class wikisooop {
	public static void main(String[] args) {
		String src = "https://en.wikipedia.org/wiki/Horse";
		Document doc;
		String[] titles;
		try {
			doc = Jsoup.connect(src).get();
			titles = parseDoc(doc);
			System.out.print(titles);
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	public static String[] parseDoc(Document d) {
		Elements es;
		String[] t;
		// get all p elements with <a></a> with an href that begins with /wiki
		es = d.select("p a[href^=/wiki]");
		t = new String[es.size()];
		int i = 0;
		for (Element e : es) {
			// get attributes of each element and the value of the title attribute
			t[i++] = e.attributes().get("title"); 
			System.out.println(t[i-1]);  // print out the title added - move this later
		}
		return t;
	}

}
