package com.naya.never_use_switch;

/**
 * @author Evgeny Borisov
 */
public interface Distributor {
    void distribute(Message message);
    int getMyCode();
}
