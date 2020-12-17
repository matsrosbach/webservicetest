package no.rosbach.webservicetest;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "messages")
    public DefaultWsdl11Definition messagesDefinition(XsdSchema messagesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MessagesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://schemas.microsoft.com/exchange/services/2006/messages");
        wsdl11Definition.setSchema(messagesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "types")
    public DefaultWsdl11Definition typesDefinition(XsdSchema typesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TypesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://schemas.microsoft.com/exchange/services/2006/messages");
        wsdl11Definition.setSchema(typesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema messagesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("messages.xsd"));
    }

    @Bean
    public XsdSchema typesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("types.xsd"));
    }
}
