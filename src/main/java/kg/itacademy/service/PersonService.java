package kg.itacademy.service;
import kg.itacademy.dao.HistoryDao;
import kg.itacademy.dao.PersonDao;
import kg.itacademy.model.History;
import kg.itacademy.model.Person;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

// URI:
// contextPath/servletPath/users
@Path("/person")
public class PersonService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getUsers_JSON() {
        System.out.println("Getting users");
        PersonDao personDao = new PersonDao();
        List<Person> users = personDao.getAllPerson();
        return users;
    }
    @GET
    @Path("/history")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<History> getHistory_JSON() {

        HistoryDao historyDao = new HistoryDao();
        historyDao.connect();
        List<History> history = historyDao.getAllHistory();
//        Don't Repeat Yourself
        return history;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String addPerson(Person person){
        HistoryDao hd = new HistoryDao();
        hd.addHistory(new History(HistoryDao.nextId++, person.toString()));
        String gender = person.getGender().equals("female") ? "F" : "M";
        String result = gender + ",Dear " + person.getName() + ", your year of birth is " + person.getDateOfBirth() + ", you are " + (LocalDateTime.now().getYear() - person.getDateOfBirth()) + " years old.";
        return result;
    }
}
