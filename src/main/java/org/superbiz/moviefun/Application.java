package org.superbiz.moviefun;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.superbiz.moviefun.blobstore.Blob;
import org.superbiz.moviefun.blobstore.BlobStore;

import java.io.IOException;
import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean actionServletRegistration(ActionServlet actionServlet) {
        return new ServletRegistrationBean(actionServlet, "/moviefun/*");
    }

    @Bean
    public BlobStore blobStore() {
        return new BlobStore() {
            @Override
            public void put(Blob blob) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override
            public Optional<Blob> get(String name) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override
            public void deleteAll() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
