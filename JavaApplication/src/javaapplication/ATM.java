package javaapplication;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ATM {

    private LinkedHashMap<Integer, Integer> customerNotes;
    private LinkedHashMap<Integer, Integer> availableNotes;

    public ATM() {
        availableNotes = new LinkedHashMap<>();
        availableNotes.put(1000, 10);
        availableNotes.put(500, 10);
        availableNotes.put(100, 10);
        availableNotes.put(50, 10);
        availableNotes.put(20, 10);

        customerNotes = new LinkedHashMap<>();
    }

    public boolean withdraw(int amount) {
        LinkedHashMap<Integer, Integer> tmpAvailableNotes = new LinkedHashMap<>(availableNotes);
        LinkedHashMap<Integer, Integer> tmpCustomerNotes = new LinkedHashMap<>();
        List keys = new ArrayList(tmpAvailableNotes.keySet());

        for (int i = 0; i < keys.size(); i++) {

            int note = (int) keys.get(i);

            if (amount >= note && tmpAvailableNotes.get(note) > 0) {
                int bill = amount / note;
                if (tmpAvailableNotes.get(note) - bill < 0) {
                    tmpAvailableNotes.put(note, 0);
                    amount = amount - (tmpAvailableNotes.get(note) * note);
                    tmpAvailableNotes.put(note, tmpAvailableNotes.get(note));
                } else {
                    tmpAvailableNotes.put(note, tmpAvailableNotes.get(note) - bill);
                    amount = amount - (bill * note);
                    tmpCustomerNotes.put(note, bill);
                }
            }
        }
        boolean isWithdrawable = amount == 0;
        if (isWithdrawable) {
            availableNotes = tmpAvailableNotes;
            customerNotes = tmpCustomerNotes;
            System.out.println("You get: " + customerNotes.toString());
        } else {
            System.out.println("Sorry, something went wrong. Please try again.");
        }
        System.out.println("Available cash: " + availableNotes.toString());
        System.out.println("===============");
        return isWithdrawable;
    }

    public LinkedHashMap<Integer, Integer> getCustomerNotes() {
        return customerNotes;
    }

    public LinkedHashMap<Integer, Integer> getAvailableNotes() {
        return availableNotes;
    }
}
