package nedj.train.task1webservice.nedj.train.testscontrollers;

import nedj.train.task1webservice.nedj.train.controller.TradingAccountController;
import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import nedj.train.task1webservice.nedj.train.repository.TradingAccountRepository;
import nedj.train.task1webservice.nedj.train.service.TradingAccountService;
import org.assertj.core.util.Arrays;
import org.json.JSONArray;
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

import java.util.ArrayList;
import java.util.List;

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

        Mockito.when(tradingAccountService.accountBalanceObject(Mockito.anyInt()))
                .thenReturn(24531);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trading-account/account-balance/4").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "24531";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);


    }

}
