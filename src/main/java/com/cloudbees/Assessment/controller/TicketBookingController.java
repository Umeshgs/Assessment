package com.cloudbees.Assessment.controller;

import com.cloudbees.Assessment.entity.Train;
import com.cloudbees.Assessment.service.TicketBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class TicketBookingController {

    private Train train;
    private TicketBookingService bookingService;
    private TrainController trainController;

    public TicketBookingController(TicketBookingService bookingService, TrainController trainController) {
        this.bookingService = bookingService;
        this.trainController = trainController;
        train = Train.getTrain();
    }

    @GetMapping("/bookTrainSeat")
    public String bookTrainSeat() {
        /*train.setSection(trainSection);
        boolean isBooked = bookingService.bookSeat(train, from, to, firstName, lastName, email);
        if(isBooked) {
            return "Ticket booked successfully for customer: "+firstName + " " + lastName;
        }
        return "No seat available in " + train.getSection() + " of the train";*/
        return "book-train-seat";
    }

    @PostMapping("/bookTrainSeat")
    public String bookTrainSeatPost(@RequestParam String from,
                                @RequestParam String to,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String email,
                                @RequestParam String trainSection,
                                    ModelMap model) {

            train.setSection(trainSection);
            boolean isBooked = bookingService.bookSeat(train, from, to, firstName, lastName, email, trainSection);
            if (isBooked) {
                model.put("name", firstName + " " + lastName);
                return "booking-success";
            }
            model.put("section", train.getSection());
            return "booking-failure";
    }


}
