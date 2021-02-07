package dev.dmohindru.springdata.filedata.repos;

import dev.dmohindru.springdata.filedata.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
