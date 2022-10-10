package com.vezinet;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import com.vezinet.kafka.KafkaProducer;


public class connectivity {

//	private GreeterGrpc.GreeterBlockingStub blockingStub;

	private List<getdata> list;

	@Autowired
	private KafkaProducer kafkaProducer;

	public void message() throws Exception {
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j).getId());
			System.out.println(list.get(j).getIp());
			System.out.println(list.get(j).getPort());

		}

	}

	public void send() {
		String message = "vezinet, 2.0";
		try {
			File f = new File("data/");
			File[] list = f.listFiles();
			for (File file : list) {
				if (file.isFile()) {
					if (file.getName().contains(".txt")) {
						// System.out.println(file.getName());
						File f1 = new File("data/" + file.getName());
						Scanner s = new Scanner(f1);
						while (s.hasNext()) {
							message += s.nextLine();
						}
						f1.delete();
						s.close();
					}
					file.delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	//	HelloRequest request = HelloRequest.newBuilder().setName(list.get(0).getId() + "--" + message).build();
	//	HelloReply response;
	//	try {
	//		response = blockingStub.sayHello(request);
	//	} catch (Exception e) {
	//	}
		kafkaProducer.sendDataToTopic("test", list.get(0).getId() + "--" + message);
	}

	public List<getdata> getList() {
		return list;
	}

	public void setList(List<getdata> list) {
		this.list = list;

	}
}
