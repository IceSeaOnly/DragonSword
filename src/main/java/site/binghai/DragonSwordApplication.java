package site.binghai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.binghai.app.JsonComparator;

import java.util.Arrays;

//@SpringBootApplication
public class DragonSwordApplication {

	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("没有输入任何命令");
		}
		new JsonComparator().invokeFunction(args);
	}
}
