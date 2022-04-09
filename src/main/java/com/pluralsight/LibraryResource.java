package com.pluralsight;

import com.pluralsight.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getIt() {
        List<Book> books = new ArrayList<>();

        Book basicBook = new Book();
        basicBook.setId(1L);
        basicBook.setName("Book of knowledge");

        books.add(basicBook);

        return books;
    }
}
