package nedj.train.task1webservice.nedj.train.testscontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.controller.TradingAccountController;
import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import net.bytebuddy.jar.asm.commons.JSRInlinerAdapter;
import org.assertj.core.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.swing.*;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TradingAccountController.class, secure = false)
public class TradingAccountTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TradingAccountService  tradingAccountService;

    @MockBean
    private TradingAccountRepository tradingAccountRepository;

    @Test
    public void getBalance() throws Exception {

        Mockito.when(tradingAccountService.accountBalance(Mockito.anyInt()))
                .thenReturn((double) 24531);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trading-account/account-balance/4").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "24531";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);


    }

    @Test
    public void getAccount() throws Exception {

        Mockito.when(this.tradingAccountService.getTradingAccount(5)).thenReturn(
                new TradingAccount(5, "Lerato Thokolo", 29450));


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trading-account/find-one/5").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();


        TradingAccount ta = new TradingAccount(5, "Lerato Thokolo", 29450);

        String expected = objectMapper.writeValueAsString(ta);

        assertEquals(expected, result.getResponse().getContentAsString());

    }

    @Test
    public void createAccount() throws Exception {

        TradingAccount tradingAccount = new TradingAccount(75, "Lebelo Malome", 758291);

        ObjectMapper objectMapper = new ObjectMapper();

        String dataToPost = objectMapper.writeValueAsString(tradingAccount);

        Mockito.when(this.tradingAccountService.createAccount(Mockito.any(TradingAccount.class))).thenReturn("Trading account created successfully!!");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/trading-account/create-account").accept(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(dataToPost))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "Trading account created successfully!!";

        assertEquals(expected, result.getResponse().getContentAsString());
    }


}
