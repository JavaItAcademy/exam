package kg.itacademy.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;

@XmlRootElement(name="history")
@XmlAccessorType(XmlAccessType.FIELD)
public class History {
    int id;
        String body;

    public History() {}
    public History(int id, String body) {
        this.id = id;
        this.body = body;

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
