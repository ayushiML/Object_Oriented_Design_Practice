package Models;

import Enums.HttpMethod;

public class UniqueUrl {
    public String httpMethod;
    public String url;
    public int freq;
    public String maskedUrl;
    public double totalTime;
    public UniqueUrl(String h , String url, String maskedUrl)
    {
        this.url = url ;
        httpMethod = h;
        freq = 0;
        this.maskedUrl = maskedUrl;
        //totalTime = time;

    }
}
