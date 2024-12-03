package com.cloudbees.Assessment.service;

import com.cloudbees.Assessment.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TrainService {
    Map<User, Integer> section1UserSeatMap;
    Map<User, Integer> section2UserSeatMap;
    //Train train;

    public TrainService() {
        this.section1UserSeatMap = new HashMap<>();
        this.section2UserSeatMap = new HashMap<>();
        //train = Train.getTrain();
    }

    public void addSeat(User user, int seatNo, String section) {
        if(section.equals("Section 1")) {
            section1UserSeatMap.put(user, seatNo);
        }
        else {
            section2UserSeatMap.put(user, seatNo);
        }
    }

    public Map<User, Integer> getUserSeatMap(String section) {
        if(section.equals("Section 1")) {
            return section1UserSeatMap;
        }
        return section2UserSeatMap;
    }

    public String removeUser(String firstName) {

        for(Map.Entry<User, Integer> entry : section1UserSeatMap.entrySet()) {
            if(entry.getKey().getFirstName().equals(firstName)) {
                section1UserSeatMap.remove(entry.getKey());
                return "Customer " + firstName + " removed from the train";
            }
        }

        for(Map.Entry<User, Integer> entry : section2UserSeatMap.entrySet()) {
            if(entry.getKey().getFirstName().equals(firstName)) {
                section2UserSeatMap.remove(entry.getKey());
                return "Customer " + firstName + " removed from the train";
            }
        }
        return "Given user is not a passenger of the train";
    }

    public String modifySeat(String firstName, int newSeatNo) {
        Collection<Integer> section1Seats =  section1UserSeatMap.values();
        for(Map.Entry<User, Integer> entry : section1UserSeatMap.entrySet()) {
            if(entry.getKey().getFirstName().equals(firstName)) {
                if(!section1Seats.contains(newSeatNo)) {
                    section1UserSeatMap.put(entry.getKey(), newSeatNo);
                    return "User " + firstName + " is allocated the new seat";
                }
            }
        }

        Collection<Integer> section2Seats = section2UserSeatMap.values();
        for(Map.Entry<User, Integer> entry : section2UserSeatMap.entrySet()) {
            if(entry.getKey().getFirstName().equals(firstName)) {
                if(!section2Seats.contains(newSeatNo)) {
                    section2UserSeatMap.put(entry.getKey(), newSeatNo);
                    return "User " + firstName + " is allocated the new seat";
                }
            }
        }

        return "Given seat no " + newSeatNo + " is already occupied or is invalid";
    }
}
