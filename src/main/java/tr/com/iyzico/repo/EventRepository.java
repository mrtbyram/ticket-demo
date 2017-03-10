package tr.com.iyzico.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.iyzico.repo.entity.Event;

import java.util.List;

/**
 * Created by muratbayram on 07/03/2017.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{

    @Override
    List<Event> findAll();
}
