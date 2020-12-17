package no.rosbach.webservicetest;

import com.microsoft.schemas.exchange.services._2006.messages.ArrayOfResponseMessagesType;
import com.microsoft.schemas.exchange.services._2006.types.SubscriptionStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class NotificationEndpoint {
    private static final String NAMESPACE_URI = "http://schemas.microsoft.com/exchange/services/2006/messages";


    @Autowired
    public NotificationEndpoint() {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendNotification")
    @ResponsePayload
    public JAXBElement<SubscriptionStatusType> sendNotification(@RequestPayload JAXBElement<ArrayOfResponseMessagesType> responseMessages) {
        System.out.println("Hei");
        return null;
    }
}
