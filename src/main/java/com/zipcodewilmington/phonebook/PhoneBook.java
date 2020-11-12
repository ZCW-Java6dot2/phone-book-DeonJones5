package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<String, List<String>>();

    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)){
            List<String> updatedNumbers = phonebook.get(name);
            updatedNumbers.add(phoneNumber);
            phonebook.replace(name, updatedNumbers);
        } else {
            phonebook.put(name, Collections.singletonList(phoneNumber));
        }


    }

    public void addAll(String name, String... phoneNumbers) {
        if (phonebook.containsKey(name)){
            List<String> updatedNumbers = phonebook.get(name);
            updatedNumbers.addAll(Arrays.asList(phoneNumbers)); // coverting array to list
            phonebook.replace(name, updatedNumbers);
        } else {
            phonebook.put(name, Arrays.asList(phoneNumbers));
        }
    }

    public void remove(String name) {
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {


        return phonebook.get(name);
    }

    // look up by phone number and not name
    public String reverseLookup(String phoneNumber)  {
       Set<String> allKeys = phonebook.keySet(); // list that have all unique values (Example - deck of cards have each set)
        for (String key : allKeys){
            List<String> values = phonebook.get(key);
            if (values.contains(phoneNumber)){
                return key;
            }
        } return "";
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<String>();
        for (String key : phonebook.keySet()){
            contactNames.add(key);

        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
