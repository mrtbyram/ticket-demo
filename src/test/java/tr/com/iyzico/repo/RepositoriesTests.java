package tr.com.iyzico.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.iyzico.IyzicoticketApplication;
import tr.com.iyzico.repo.model.Event;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@Import(IyzicoticketApplication.class)
@ActiveProfiles("test")
public class RepositoriesTests {

	@Autowired
	EventRepository eventRepo;

	@Autowired
	TalkRepository talkRepo;

	@Test
	public void eventrepo_should_find_by_id() throws Exception {
		String firstEventName = "Developers Day";

		Event event = eventRepo.findOne(1);

		assertEquals(firstEventName, event.getName());
	}

	@Test
	public void eventrepo_should_find_all(){
		String eventOne = "Developers Day";
		String eventTwo = "Agile Summit";
		String eventThree = "Developer Summit Istanbul";
		String eventFour = "Istanbul Tech Talks";

		List<String> events = new ArrayList<>();
		eventRepo.findAll().forEach(event -> events.add(event.getName()));

		assertTrue(events.contains(eventOne));
		assertTrue(events.contains(eventTwo));
		assertTrue(events.contains(eventThree));
		assertTrue(events.contains(eventFour));
	}

	@Test
	public void talkrepo_should_find_by_event_id(){
		String talkOne = "SpringBoot";
		String talkTwo = "Git Repository";

		List<String> talks = new ArrayList<>();
		talkRepo.findTalkByEventId(1).forEach(talk -> talks.add(talk.getSubject()));

		assertTrue(talks.contains(talkOne));
		assertTrue(talks.contains(talkTwo));
	}

}