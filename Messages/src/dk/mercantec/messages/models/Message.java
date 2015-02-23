package dk.mercantec.messages.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.faces.bean.SessionScoped;

/**
 * Created by code on 22-02-2015.
 */
@DatabaseTable(tableName="Massage")
public class Message {
    public Message(String title, String message) {
        this.title = title;
        this.message = message;
    }
    public Message() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String message;

}
