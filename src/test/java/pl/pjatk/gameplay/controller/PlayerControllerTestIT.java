package pl.pjatk.gameplay.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.PlayerService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/player")).andDo(print()).andExpect(status().isOk());

    }

//     utowrzyc test aby sprawdzic czy zwraca podana wartosc / stworzyc metode w player controler z "/player/test"
//    @Test
//    void shouldMatchContent() throws Exception {
//        mockMvc.perform(get("/player/test"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello")));
//    }

    @Test
    void shouldNotFound() throws Exception {
        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldFoundPlayer() throws Exception {
        playerService.save(new Player("nickname", 100, 10, 10));

        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(
                        "{\"id\":1,\"nickname\":\"nickname\",\"health\":100,\"attack\":10,\"mana\":10}")));
    }
}
