package com.ceantolentino.string;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringApplication.class, args);
}

    // 1. Annotation
    @RequestMapping("/")
	// 3. Method that maps to the request route above
	public String hello() { // 3
        return "<h1>Hello World, how are you?</h1>";
	}
    @RequestMapping("/random")
	// 3. Method that maps to the request route above
	public String random() { // 3
        return "<h1>Spring boot is great!!</h1>";
	}

}
