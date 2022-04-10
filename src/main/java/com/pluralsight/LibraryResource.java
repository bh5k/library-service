package com.pluralsight;

import com.pluralsight.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

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
    @GET
    @Path("{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getIt(@PathParam("index") Integer index) {
        List<Book> books = new ArrayList<>();

        Book basicBook = new Book();
        basicBook.setId(1L);
        basicBook.setName("Book of knowledge");

        books.add(basicBook);

        return books.get(index);
    }
}
