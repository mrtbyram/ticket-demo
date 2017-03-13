package tr.com.iyzico.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.iyzico.IyzicoticketApplication;
import tr.com.iyzico.repo.entity.Event;

import java.text.SimpleDateFormat;
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
		String firstEventDesc = "New technologies about software development";
		String firstEventPlace = "Istanbul Convention Center";
		String firstEventDate = "2017-05-12";

		Event event = eventRepo.findOne(1);

		assertEquals(firstEventName, event.getName());
		assertEquals(firstEventDesc, event.getDescription());
		assertEquals(firstEventPlace, event.getPlace());
		assertEquals(firstEventDate, new SimpleDateFormat("yyyy-MM-dd").format(event.getDate()));
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
		String subjectOne = "SpringBoot";
		String subjectTwo = "Git Repository";

		String speakerOne = "Murat Bayram";
		String speakerTwo = "Onur Yardimci";

		List<String> subjects = new ArrayList<>();
		List<String> speakers = new ArrayList<>();

		talkRepo.findTalkByEventId(1)
				.forEach(talk -> {
					subjects.add(talk.getSubject());
					speakers.add(talk.getSpeaker());
				});

		assertTrue(subjects.contains(subjectOne));
		assertTrue(subjects.contains(subjectTwo));

		assertTrue(speakers.contains(speakerOne));
		assertTrue(speakers.contains(speakerTwo));
	}

}