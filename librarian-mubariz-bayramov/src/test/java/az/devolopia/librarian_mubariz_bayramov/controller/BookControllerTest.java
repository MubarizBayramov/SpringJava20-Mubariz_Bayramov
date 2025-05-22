package az.devolopia.librarian_mubariz_bayramov.controller;

import az.devolopia.librarian_mubariz_bayramov.response.BookSingleResponse;
import az.devolopia.librarian_mubariz_bayramov.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;

    @Test
    void testFindById() throws Exception {
        
        int id = 1;
        BookSingleResponse response = new BookSingleResponse();
        response.setId(id);
        response.setName("Effective Java");
        response.setAuthor("Joshua Bloch");

      
        when(service.findById(id)).thenReturn(response);

      
        mockMvc.perform(get("/books/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }
}
