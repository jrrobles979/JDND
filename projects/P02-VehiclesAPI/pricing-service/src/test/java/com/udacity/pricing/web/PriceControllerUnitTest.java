package com.udacity.pricing.web;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
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
        System.out.println("");
        mockMvc.perform(get("/services/price?vehicleId="+defaultVehicleId))
                .andExpect(status().isOk());

        verify(pricingService, times(1)).getPrice(defaultVehicleId);
    }


}
