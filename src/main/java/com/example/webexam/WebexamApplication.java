package com.example.webexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;

@SpringBootApplication
public class WebexamApplication implements CommandLineRunner {

//	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
//	org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping
//	org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
//	org.springframework.web.servlet.function.support.RouterFunctionMapping
//	org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
	@Autowired
	List<HandlerMapping> handlerMappings; // HandlerMapping Bean들을 모두 가져온다.


//	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
//	org.springframework.web.servlet.function.support.HandlerFunctionAdapter
//	org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter
//	org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
	@Autowired
	List<HandlerAdapter> handlerAdapters; // HandlerAdapter Bean들을 모두 가져온다.
	public static void main(String[] args) {
		SpringApplication.run(WebexamApplication.class, args);
	}


//	org.springframework.web.servlet.view.ContentNegotiatingViewResolver
//	org.springframework.web.servlet.view.BeanNameViewResolver
//	org.springframework.web.servlet.view.ViewResolverComposite
//	org.springframework.web.servlet.view.InternalResourceViewResolver
	@Autowired
	List<ViewResolver> viewResolvers;

	@Override
	public void run(String... args) throws Exception {
		for(ViewResolver viewResolver : viewResolvers){
			System.out.println(viewResolver.getClass().getName());
		}
	}
}
