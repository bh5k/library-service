package com.pluralsight;

import com.pluralsight.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("library")
public class LibraryResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Book putIt(Book book) {

        System.out.println(book);

        return book;
    }
}
