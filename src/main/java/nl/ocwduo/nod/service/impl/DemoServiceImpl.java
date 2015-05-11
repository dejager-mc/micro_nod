package nl.ocwduo.nod.service.impl;

import nl.ocwduo.nod.jms.DemoJmsMessageSender;
import nl.demo.springjms.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Machiel on 5-5-2015.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoJmsMessageSender demoJmsMessageSender;

    public void sendDemoMessage(String message) {
        demoJmsMessageSender.demoSendMessage(message);
    }

    public void setDemoJmsMessageSender(DemoJmsMessageSender demoJmsMessageSender) {
        this.demoJmsMessageSender = demoJmsMessageSender;
    }
}
