package tr.com.iyzico.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ViewControllersTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void index_should_return_index() throws Exception {

		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));

	}

	@Test
	public void events_should_return_events() throws Exception {

		mockMvc.perform(get("/events"))
				.andExpect(status().isOk())
				.andExpect(view().name("events"));

	}

	@Test
	public void event_should_return_eventdetail() throws Exception {

		mockMvc.perform(get("/event/123"))
				.andExpect(status().isOk())
				.andExpect(view().name("event-detail"));

	}
}
