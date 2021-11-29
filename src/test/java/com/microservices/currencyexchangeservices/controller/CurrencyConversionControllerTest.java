package com.microservices.currencyexchangeservices.controller;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CurrencyConversionController.class})
@ExtendWith(SpringExtension.class)
class CurrencyConversionControllerTest {
    @Autowired
    private CurrencyConversionController currencyConversionController;

    @Test
    void testCalculateCurrencyConversion() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}", "jane.doe@example.org",
                "alice.liddell@example.org", BigDecimal.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.currencyConversionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1001,\"from\":\"jane.doe@example.org\",\"to\":\"alice.liddell@example.org\",\"conversionMultiple\":1,"
                                        + "\"quantity\":1,\"totalCalculatedAmount\":1,\"environment\":\" \"}"));
    }

    @Test
    void testCalculateCurrencyConversion2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get(
                "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}", "jane.doe@example.org",
                "alice.liddell@example.org", BigDecimal.valueOf(1L));
        getResult.contentType("text/plain");
        MockMvcBuilders.standaloneSetup(this.currencyConversionController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1001,\"from\":\"jane.doe@example.org\",\"to\":\"alice.liddell@example.org\",\"conversionMultiple\":1,"
                                        + "\"quantity\":1,\"totalCalculatedAmount\":1,\"environment\":\" \"}"));
    }
}

