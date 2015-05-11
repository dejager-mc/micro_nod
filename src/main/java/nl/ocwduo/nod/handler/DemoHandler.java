package nl.ocwduo.nod.handler;

import nl.demo.springjms.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Machiel on 3-5-2015. okok
 */
@Component
@ManagedBean
@SessionScoped
public class DemoHandler implements Serializable {

    @Autowired
    DemoService demoService;

    private String demoMessage;

    /**
     * Method registers user
     */
    public void sendDemoMessage() {
        // Output some info
        System.out.println("Sending message: " + demoMessage);

        // Business logic
        demoService.sendDemoMessage(demoMessage);

        // Set the message here
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sending demo message to out.queue", "success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    public String getDemoMessage() {
        return demoMessage;
    }

    public void setDemoMessage(String demoMessage) {
        this.demoMessage = demoMessage;
    }
}
