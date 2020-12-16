package com.udacity.pricing.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PriceControllerUnitTest {
    private static final Long defaultVehicleId=1l;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PricingService pricingService;


    @Test
    public void getPrice() throws Exception {

        MvcResult result = mockMvc.perform(get("/services/price?vehicleId="+defaultVehicleId))
                .andExpect(status().isOk()).andReturn();
        verify(pricingService, times(1)).getPrice(defaultVehicleId);

    }

}
