package gal.uvigo.esei.dm.mypingpongapp;

import java.io.Serializable;

public class PingPongData implements Serializable {

    private Integer counter;
    private String value;

    public PingPongData(Integer counter, String value){
        this.counter = counter;
        this.value = value;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
