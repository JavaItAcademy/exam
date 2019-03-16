package kg.itacademy.dao;

import kg.itacademy.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDao {
    private static final Map<Integer, Person> personMap = new HashMap<>();


    public ArrayList<Person> getAllPerson() {
        return new ArrayList<>(personMap.values());
    }


}
