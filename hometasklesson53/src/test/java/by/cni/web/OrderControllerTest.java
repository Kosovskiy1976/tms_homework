package by.cni.web;

import by.cni.dto.OrderDto;
import by.cni.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import wiremock.org.hamcrest.CoreMatchers;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class OrderControllerTest {

    @RegisterExtension
    static WireMockExtension WIREMOCK = WireMockExtension.newInstance()
            .options(WireMockConfiguration.options().port(8081))
            .build();

    @Value("classpath:/json/order_create_request.json")
    private File createOrderFile;

    @Value("classpath:/json/order_ok_respons.json")
    private File resultOrderFile;

    @Value("classpath:/json/order_wrong_respons.json")
    private File resultOrderFileWrong;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void addOrder() throws Exception {

        OrderDto resultOk = mapper.readValue(resultOrderFile, OrderDto.class);
        String wireResultOk = mapper.writeValueAsString(resultOk);

        OrderDto orderDto = mapper.readValue(createOrderFile, OrderDto.class);
        String content = mapper.writeValueAsString(orderDto);

        WIREMOCK.stubFor(WireMock.post("/order")
                .willReturn(WireMock.ok().withBody(wireResultOk)
                        .withHeader("Content-Type", "application/json")));

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfPhone", is(resultOk.getNumberOfPhone())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idOfCinema", is(resultOk.getIdOfCinema())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idOfSession", is(resultOk.getIdOfSession())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idOfPlace", is(resultOk.getIdOfPlace())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", is("accepted")));

    }

    @Test
    void addOrderUnSuccess() throws Exception {

        OrderDto resultWrong = mapper.readValue(resultOrderFileWrong, OrderDto.class);
        String wireResultWrong = mapper.writeValueAsString(resultWrong);

        OrderDto orderDto = mapper.readValue(createOrderFile, OrderDto.class);
        String content = mapper.writeValueAsString(orderDto);

        WIREMOCK.stubFor(WireMock.post("/order")
                .willReturn(WireMock.ok().withBody(wireResultWrong)
                        .withHeader("Content-Type", "application/json")));

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.reason", is("refused")));

    }
}