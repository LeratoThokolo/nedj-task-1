package nedj.train.task1webservice.nedj.train.testscontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nedj.train.task1webservice.nedj.train.controller.TradingAccountController;
import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
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
                .thenReturn(Double.valueOf((14685246)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trading-account/account-balance/5").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        double expected = 14685246;

        JSONAssert.assertEquals(String.valueOf(expected), result.getResponse().getContentAsString(), false);


    }

    @Test
    public void getAccount() throws Exception {

        Mockito.when(this.tradingAccountService.getTradingAccount(5)).thenReturn(
                new TradingAccount(5, "Lerato Thokolo", 14685246));


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trading-account/get-one/5").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();


        TradingAccount ta = new TradingAccount(5, "Lerato Thokolo", 14685246);

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
