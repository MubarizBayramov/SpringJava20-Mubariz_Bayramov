package az.devolopia.tourist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import az.devolopia.tourist.request.ObjectAddRequest;
import az.devolopia.tourist.response.ObjectAddResponse;
import az.devolopia.tourist.service.ObjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ObjectController.class)
public class ObjectControllerTest {
   
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ObjectService objectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddObject_ValidRequest_ReturnsCreated() throws Exception {
        ObjectAddRequest request = new ObjectAddRequest();
        request.setName("Villa");
        request.setDescription("Gözəl villa");
        request.setPrice(new BigDecimal("120.50"));
        request.setPublishDate(LocalDate.of(2020, 1, 1));

        ObjectAddResponse response = new ObjectAddResponse();
        response.setId(1);

        when(objectService.add(request)).thenReturn(response);

        mockMvc.perform(post("/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testAddObject_InvalidNameTooShort_ReturnsBadRequest() throws Exception {
        ObjectAddRequest request = new ObjectAddRequest();
        request.setName("A"); // invalid: min 2
        request.setDescription("Test");
        request.setPrice(new BigDecimal("60.00"));
        request.setPublishDate(LocalDate.of(2020, 1, 1));

        mockMvc.perform(post("/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testAddObject_EmptyDescription_ReturnsBadRequest() throws Exception {
        ObjectAddRequest request = new ObjectAddRequest();
        request.setName("Villa");
        request.setDescription("  "); // invalid: @NotBlank
        request.setPrice(new BigDecimal("100.00"));
        request.setPublishDate(LocalDate.of(2020, 1, 1));

        mockMvc.perform(post("/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testAddObject_InvalidPriceTooHigh_ReturnsBadRequest() throws Exception {
        ObjectAddRequest request = new ObjectAddRequest();
        request.setName("Villa");
        request.setDescription("Test");
        request.setPrice(new BigDecimal("1500.00")); // invalid: max 1000
        request.setPublishDate(LocalDate.of(2020, 1, 1));

        mockMvc.perform(post("/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testAddObject_FuturePublishDate_ReturnsBadRequest() throws Exception {
        ObjectAddRequest request = new ObjectAddRequest();
        request.setName("Villa");
        request.setDescription("Test");
        request.setPrice(new BigDecimal("120.00"));
        request.setPublishDate(LocalDate.now().plusDays(5)); // invalid: @Past

        mockMvc.perform(post("/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
