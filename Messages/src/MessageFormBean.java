import dk.mercantec.messages.models.DbHelper;
import dk.mercantec.messages.models.Message;
import org.hibernate.validator.constraints.NotEmpty;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;

/**
 * Created by code on 22-02-2015.
 */
@ManagedBean(name = "MessagesForm")
@RequestScoped
public class MessageFormBean {
    @NotEmpty(message = "The title field can not be empty")
    private String title;
    private String message;

    public void addMessage() {
        Message messageObj = new Message(title, message);
        try {
            DbHelper.getInstance().getMessageDao().create(messageObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        title="";
        message="";
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

}
