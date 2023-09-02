import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlSelector {
    
    public void doc(){
        Document doc = null;

        File input = new File("/tmp/input.html");
        String url = "https://www.albamon.com/jobs/total";

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Elements els = doc.select("a[href]");
        
        for (Element el : els) {
            String str = el.text();
            System.out.println(str);
        }
    }

}
