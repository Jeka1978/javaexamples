package com.naya.never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class EmailDistributor implements Distributor {
    @Override
    public void distribute(Message message) {
        System.out.println("Sent by Email");
    }

    @Override
    public int getMyCode() {
        return 3;
    }
}
