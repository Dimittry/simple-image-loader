package imageloader.imageloader.Repositories;

import imageloader.imageloader.Entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {
    public Image findByName(final String name);
}
