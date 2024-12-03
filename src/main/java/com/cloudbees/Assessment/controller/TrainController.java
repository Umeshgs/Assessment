package com.cloudbees.Assessment.controller;

import com.cloudbees.Assessment.entity.User;
import com.cloudbees.Assessment.service.TrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/home")
public class TrainController {
    private TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    public void addSeat(User user, int seatNo, String section) {
        trainService.addSeat(user, seatNo, section);
    }

    @GetMapping("/getSeatAllocation")
    public String getAllocations(@RequestParam String section) {
        Map<User, Integer> userSeatMap = trainService.getUserSeatMap(section);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<User, Integer> entry : userSeatMap.entrySet()) {
            sb.append(entry.getKey())
              .append(" is allocated seat ")
              .append(entry.getValue())
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam String firstName) {
        return trainService.removeUser(firstName);
    }

    @GetMapping("/modifySeat")
    public String removeUser(@RequestParam String firstName, @RequestParam int newSeatNo) {
        return trainService.modifySeat(firstName, newSeatNo);
    }
}
