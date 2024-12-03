package com.cloudbees.Assessment.service;

import com.cloudbees.Assessment.controller.TrainController;
import com.cloudbees.Assessment.controller.UserController;
import com.cloudbees.Assessment.entity.Ticket;
import com.cloudbees.Assessment.entity.Train;
import com.cloudbees.Assessment.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    TrainController trainController;
    UserController userController;

    public TicketBookingService(TrainController trainController, UserController userController) {
        this.trainController = trainController;
        this.userController = userController;
    }

    public boolean bookSeat(Train train, String from, String to, String firstName, String lastName, String email, String trainSection) {

        if(train.getSeats() == 0) {
            return false;
        }

        int bookedSeat = train.bookSeat(trainSection);
        User cust = new User(firstName, lastName, email);
        trainController.addSeat(cust, bookedSeat, trainSection);
        Ticket ticket = new Ticket(from, to, cust);
        userController.addReceipt(firstName, ticket);
        //return ticket.toString();
        return true;
    }

}
