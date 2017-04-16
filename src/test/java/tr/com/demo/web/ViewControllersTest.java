package tr.com.demo.web;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tr.com.demo.TicketApplication;
import tr.com.demo.repo.EventRepository;
import tr.com.demo.repo.entity.Event;

import java.util.ArrayList;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TicketApplication.class)
@ActiveProfiles("test")
public class ViewControllersTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

//	@MockBean
//	private EventRepository eventRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
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
//		given(eventRepo.findAll()).willReturn(new ArrayList<Event>());
		mockMvc.perform(get("/events"))
				.andExpect(status().isOk())
				.andExpect(view().name("events"))
				.andExpect(model().attribute("events", Matchers.hasSize(4)));
	}

	@Test
	public void event_should_return_eventdetail() throws Exception {
		mockMvc.perform(get("/event/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("event-detail"));
	}

	@Test
	public void event_should_return_noevent() throws Exception {
		mockMvc.perform(get("/event/999"))
				.andExpect(status().isOk())
				.andExpect(view().name("no-event"));

		mockMvc.perform(get("/event/ASD"))
				.andExpect(status().isOk())
				.andExpect(view().name("no-event"));

	}

}
