package Hongikstruggle.HongAlliance.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Store {

    private static String CLIENTID;

    @Value("mqmj50lnne")
    public void setCLIENTID(String clientid) {
        CLIENTID = clientid;
    }

    public static String getCLIENTID(){
        return CLIENTID;
    }

    private Integer id;
    private String name;
    private String kind;
    private double lat;
    private double lng;
    private String info; //할인 정보

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lng;
    }

    public void setLon(double lng) {
        this.lng = lng;
    }
}
