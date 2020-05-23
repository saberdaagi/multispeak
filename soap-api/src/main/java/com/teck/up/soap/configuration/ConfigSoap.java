package com.teck.up.soap.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;

@EnableWs
@Configuration
@PropertySource("classpath:config/soap/application.properties")
public class ConfigSoap extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/service/*");
	}

	@Bean(name = "trainDetailsWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("TrainDetailsPort");
		wsdl11Definition.setLocationUri("/service/train-details");
		wsdl11Definition.setTargetNamespace("http://www.reseration.com/xml");
		wsdl11Definition.setSchemaCollection( new XsdSchemaCollection(){


			@Override
			public XsdSchema[] getXsdSchemas() {
				return new XsdSchema[]{new SimpleXsdSchema(new ClassPathResource("train.xsd")),new SimpleXsdSchema(new ClassPathResource("client.xsd")),new SimpleXsdSchema(new ClassPathResource("reservation.xsd"))};
			}
			@Override
			public XmlValidator createValidator() {
				return null;
			}
		});
		wsdl11Definition.setSchema(schema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema trainSchema() {
		return new SimpleXsdSchema(new ClassPathResource("train.xsd"));
	}


}