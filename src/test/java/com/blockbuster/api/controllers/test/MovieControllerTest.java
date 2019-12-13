package com.blockbuster.api.controllers.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieRepository movieRepository;

	@Before
	public void init() {
		Movie movie = new Movie(1L);
		when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
	}

	@WithMockUser("ADMIN")
	@Test
	public void find_login_ok() throws Exception {
		mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));
	}

	@Test
	public void find_nologin_401() throws Exception {
		mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isUnauthorized());
	}

}
