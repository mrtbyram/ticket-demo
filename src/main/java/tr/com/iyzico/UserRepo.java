package tr.com.iyzico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muratbayram on 04/03/2017.
 */
public interface UserRepo extends CrudRepository<User, Integer> {
}
