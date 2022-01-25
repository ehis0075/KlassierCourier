package klasha.store.KlashaCourier.repository;


import klasha.store.KlashaCourier.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
