package Models;

import Enums.HttpMethod;

public class LogData {
    public String timestamp;
    public String url;
    public String hMethod;
    public String  responseTime;
    public String responseCode;

    public LogData(String timestamp, String url, String hMethod, String responseTime, String responseCode) {
        this.timestamp = timestamp;
        this.url = url;
        this.hMethod = hMethod;
        this.responseTime = responseTime;
        this.responseCode = responseCode;
    }

}
