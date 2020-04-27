package com.assurance.boggle.controller;

import com.assurance.boggle.entity.BoggleDto;
import com.assurance.boggle.service.BoggleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class BoggleRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BoggleService boggleService;

    @InjectMocks
    private BoggleRestController boggleRestController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(boggleRestController).build();
    }

    @After
    public void tearDown() {
        boggleRestController = null;
    }

    @Test
    public void testGetBoggleGame() throws Exception {
        when(boggleService.getBoggle()).thenReturn(new BoggleDto());

        mockMvc.perform(get("/api/v1/boggle")
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        Mockito.verify(boggleService).getBoggle();
    }
}