package pl.sda.finalapp;

import pl.sda.finalapp.products.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void shouldDisplayProductPage() throws Exception {
        //given

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products")) //sprawdzamy url z kontrolera
                .andDo(MockMvcResultHandlers.print()) // wypisanie na konsoli
                .andExpect(MockMvcResultMatchers.status().is(200)) // oczekiwany od odpowiedzi
                .andReturn(); // zwraca model and view
        //then
        String viewName = mvcResult.getModelAndView().getViewName();
        Assertions.assertEquals(viewName, "productsPage");
    }

    @Test
    void shouldAddProductToDB() throws Exception {
        //given
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        long countBefore = productRepository.count();
        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/products")
                .param("title", "t")
                .param("pictureUrl", "pUrl")
                .param("price", "4.52")
                .param("productType", "BOOK")
                .param("categoryId", "3");

        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/products");
        //when
        MvcResult postResoult = mockMvc.perform(postRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/products"))
                .andReturn();

        MvcResult getResoult = mockMvc.perform(getRequest)
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        //then
        Assertions.assertEquals( countBefore +1, productRepository.count());

    }

}
