package com.naya.never_use_switch;

/**
 * @author Evgeny Borisov
 */

public class MessageSenderImpl implements MessageSender {
    @Override
    public void send(Message message) {
        switch (message.getDistributionType()) {
            case 1:
                //20 lines of code which send sms
                System.out.println("sms was sent");
                break;
            case 2:
                // 30 lines of code
                System.out.println("whatsapp");
        }
    }
}
