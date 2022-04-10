package com.pluralsight;

import com.pluralsight.model.Book;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LibraryTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(LibraryResource.class);
    }

    @Test
    public void testPut() {
        Book book = new Book();
        book.setName("A different book");
        book.setId(2L);

        Response response = target("/library")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(book, MediaType.APPLICATION_JSON));



        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        Book returnBook = response.readEntity(Book.class);
        assertNotNull("Content of response is: ", returnBook);
    }
}
