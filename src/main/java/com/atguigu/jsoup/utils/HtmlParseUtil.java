package com.atguigu.jsoup.utils;

import com.atguigu.jsoup.pojo.Content;
import com.atguigu.jsoup.pojo.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {


    public static void getHtml() throws IOException {
        //1.获取请求 https://search.jd.com/Search?keyword=ipad

        String url = "https://search.jd.com/Search?keyword=ipad";

        //2.解析网页.(返回的Document对象就是浏览器中的Document对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        //在js中的方法在这里也可以使用
        Element element = document.getElementById("J_goodsList");

        //System.out.println(element);
        //3.获取ul下的li标签
        Elements lis = element.getElementsByTag("li");
        //这里li就是每一个li标签
        for (Element li : lis) {
            String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String title = li.getElementsByClass("p-name").eq(0).text();
            String price = li.getElementsByTag("i").eq(0).text();
            if (!img.equals("") && !title.equals("") && !price.equals("")) {
                System.out.println("=====================");
                System.out.println("标题为" + title);
                System.out.println("图片为" + img);
                System.out.println("价格为" + price);
            }

        }
    }


    public static List<Content> searchJD(String keyword, Integer page) throws Exception {

        List<Content> list = new ArrayList<>();


        for (int firstPage = 1; firstPage <= page * 2 - 1; firstPage = firstPage + 2) {

            String url = "https://search.jd.com/Search?keyword=" + keyword + "&page=" + firstPage;

            String replace = url.replace(" ", "");

            Document document = Jsoup.parse(new URL(replace), 30000);

            Element element = document.getElementById("J_goodsList");


            if (element != null) {
                Elements lis = element.getElementsByTag("li");

                for (Element li : lis) {
                    String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
                    String title = li.getElementsByClass("p-name").eq(0).text();
                    String price = li.getElementsByTag("i").eq(0).text();
                    if (!img.equals("") && !title.equals("") && !price.equals("")) {
                        Content content = new Content(title, img, price);
                        list.add(content);

                    }

                }
            }


        }
        return list;
    }

    public static List<Movie> getMovie(Integer page) throws IOException {

        List<Movie> movies = new ArrayList<>();

        for (int i = 2; i <= page; i++) {
            String url = "https://www.ygdy8.net/html/gndy/dyzz/list_23_" + i + ".html";

            Document document = Jsoup.parse(new URL(url), 10000);

            Elements element = document.getElementsByClass("co_content8");

            Element first = element.first();

            Elements ul = first.getElementsByTag("ul");

            Element first1 = ul.first();

            Elements tables = first1.getElementsByTag("table");

            for (Element table : tables) {
                Elements ulink = table.getElementsByClass("ulink");

                String movieName = ulink.text();

                String tempUrl = ulink.eq(0).attr("href");
                String url1 = "https://www.ygdy8.net" + tempUrl;
                Document document1 = Jsoup.parse(new URL(url1), 10000);
                Element zoom = document1.getElementById("Zoom");
                String img = zoom.getElementsByTag("img").eq(0).attr("src");

                String magnetic = zoom.getElementsByTag("a").eq(0).attr("href");

                Movie movie = new Movie();
                movie.setMovieId(null);
                movie.setMovieImg(img);
                movie.setMovieName(movieName);
                movie.setMovieMagnetic(magnetic);

                movies.add(movie);

            }
        }
        return movies;
    }

}
