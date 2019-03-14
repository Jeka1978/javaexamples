package com.naya.never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class WhasappDistributor implements Distributor {
    @Override
    public void distribute(Message message) {
        // 20 lines of code
        System.out.println("whasapp was sent");
    }

    @Override
    public int getMyCode() {
        return 2;
    }
}
