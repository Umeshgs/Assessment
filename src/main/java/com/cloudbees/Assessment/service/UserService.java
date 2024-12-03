package com.cloudbees.Assessment.service;

import com.cloudbees.Assessment.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, Ticket> receiptMap;

    public UserService() {
        this.receiptMap = new HashMap<>();
    }

    public void addReceipt(String user, Ticket ticket) {
        receiptMap.put(user, ticket);
    }

    public Ticket getReceipt(String user) {
        return receiptMap.get(user);
    }
}
