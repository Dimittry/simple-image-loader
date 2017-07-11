package imageloader.imageloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageLoaderApplication /*extends SpringBootServletInitializer*/ {

	/*@Bean
	public ServletRegistrationBean camelServletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new CamelHttpTransportServlet(), "/api/*"
		);
		registrationBean.setName("CamelServlet");
		return registrationBean;
	}*/

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
