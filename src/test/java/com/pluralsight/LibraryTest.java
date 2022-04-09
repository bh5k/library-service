package com.pluralsight;

import com.pluralsight.model.Book;
import jakarta.ws.rs.core.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(LibraryResource.class);
    }

    @Test
    public void testBasicGetRetrieve() {
        Response response = target("/library")
                .request(MediaType.APPLICATION_JSON)
                .get();



        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        List<Book> books = response.readEntity(new GenericType<List<Book>>() {});

        assertNotNull("Content of response is: ", books);
        assertTrue("Content of response is: ", books.size() > 0);
    }
}
