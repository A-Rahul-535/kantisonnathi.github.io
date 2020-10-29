package in.ac.bitspilani.webapp.item;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    //void save(Item item) throws DataAccessException;

    List<Item> findByCategoryId(Integer CategoryId);

    Item findById(Integer ItemId);
}
