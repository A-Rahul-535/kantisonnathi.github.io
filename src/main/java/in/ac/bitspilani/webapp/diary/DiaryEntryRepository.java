package in.ac.bitspilani.webapp.diary;


import in.ac.bitspilani.webapp.user.User;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;


public interface DiaryEntryRepository extends Repository<DiaryEntry, Integer> {


    List<DiaryEntry> findAllByUser(User user);

    DiaryEntry findByDate(LocalDate date);
}
