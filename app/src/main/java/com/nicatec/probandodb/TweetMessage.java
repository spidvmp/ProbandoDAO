package com.nicatec.probandodb;

import java.io.Serializable;

/**
 * Created by vtx on 30/4/16.
 */
public class TweetMessage  implements Serializable{
    private long id;
    private String message;



    public TweetMessage(long id, String message){
        if ( message == null || message.isEmpty()) {
            message = "";
        } else {
            this.message = message;
        }

        //si id = 0 significa que no tiene relacion en la BD,
        if ( id <= 0) {
            this.id = 0;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
