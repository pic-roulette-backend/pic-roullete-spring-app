package pic.roulette.backend.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pic.roulette.backend.model.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session,String>
{
    //Will largely stay empty. You can add extra database features here if you want!
}