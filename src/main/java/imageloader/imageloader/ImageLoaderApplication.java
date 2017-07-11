package imageloader.imageloader;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageLoaderApplication /*extends SpringBootServletInitializer*/ {

	@Bean
	public ServletRegistrationBean camelServletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new CamelHttpTransportServlet(), "/api/*"
		);
		registrationBean.setName("CamelServlet");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(ImageLoaderApplication.class, args);
	}
/*
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
	    return applicationBuilder.sources(ImageLoaderApplication.class);
    }

    private static Class<ImageLoaderApplication> applicationClass = ImageLoaderApplication.class;
    */
}
