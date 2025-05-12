package az.devolopia.librarian_mubariz_bayramov.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import az.devolopia.librarian_mubariz_bayramov.request.BookUpdateRequest;
import az.devolopia.librarian_mubariz_bayramov.response.BookSingleResponse;
import az.devolopia.librarian_mubariz_bayramov.service.BookService;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;

    @Test
    void testFindById() throws Exception {
        
        int bookId = 1;
        BookSingleResponse mockResponse = new BookSingleResponse();
        mockResponse.setId(bookId);
        mockResponse.setName("Səhra Gülü");
        mockResponse.setDescription("Gözəl bir roman");
        mockResponse.setPrice(new BigDecimal("12.50"));
        mockResponse.setAuthor("Mübariz Bayramov");
        mockResponse.setColor("Qırmızı");
        mockResponse.setPageCount(250);
        mockResponse.setQuantity(3);
        mockResponse.setWeight(0.45);
        mockResponse.setPublishDate(LocalDate.of(2024, 5, 1));

    }  
    

    @Test
    void updateBook_successful() throws Exception {
        BookUpdateRequest request = new BookUpdateRequest();
        request.setId(1);  // bu alanları öz BookUpdateRequest uyğun doldur
        request.setName("Yeni Kitab");
        request.setPrice(150.0);
        request.setLibrarianCode("lib123");

        mockMvc.perform(put("/book/update") // endpointinizə uyğun dəyişin
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Kitab uğurla yeniləndi"));

        Mockito.verify(service).update(Mockito.any(BookUpdateRequest.class));
    }

    @Test
    void updateBook_validationError() throws Exception {
        BookUpdateRequest request = new BookUpdateRequest();
        request.setId(null);  // burada id null göndərilir, yəni validation error üçün
        request.setName("");  // boş name də səhvdir
        request.setPrice(50.0);
        request.setLibrarianCode("");

        mockMvc.perform(put("/book/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest()); // Çünki MyException atılır
    }
}
