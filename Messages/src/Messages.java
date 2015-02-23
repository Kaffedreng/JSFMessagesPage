import com.j256.ormlite.stmt.QueryBuilder;
import dk.mercantec.messages.models.DbHelper;
import dk.mercantec.messages.models.Message;

import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by code on 22-02-2015.
 */
@ManagedBean(name = "Messages")
public class Messages {
    public List<Message> getMessages(){
        List<Message> messages = null;
        try {
            QueryBuilder<Message, Integer> queryBuilder = DbHelper.getInstance().getMessageDao().queryBuilder();
            queryBuilder.orderBy("id", false);
            messages = DbHelper.getInstance().getMessageDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
