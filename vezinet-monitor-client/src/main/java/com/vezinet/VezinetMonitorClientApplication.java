package com.vezinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
@ImportResource({ "classpath*:vezinet.xml" })
//@ImportResource("classpath:/config/vezinet.xml")
//@ImportResource({ "classpath:/config/vezinet.xml" })

public class VezinetMonitorClientApplication {
	
	public static void main(String[] args) {
	//	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
	 //           new String[] { "/**/vezinet.xml"});
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("vezinet.xml");
		ApplicationContext c = SpringApplication.run(VezinetMonitorClientApplication.class, args);

		connectivity conn = c.getBean("connectivity", connectivity.class);
		// conn.setSocketChannel();
		System.out.println("success");
		// connectivity conn=new connectivity();
		while (true) {
			try {
				conn.message();
				conn.send();
				Thread.sleep(1 * 30 * 1000);
			} catch (Exception e) {
			}
		}

	}

}
