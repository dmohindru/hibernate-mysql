package dev.dmohindru.springdata.filedata;

import dev.dmohindru.springdata.filedata.entities.Image;
import dev.dmohindru.springdata.filedata.repos.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	private ImageRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		image.setId(1);
		image.setName("TestImage.jpeg");

		File file = new File("/home/dhruv/Pictures/TestImage.jpeg");
		byte[] fileContent = new byte[(int)file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);
		image.setData(fileContent);
		inputStream.close();

		repository.save(image);

	}

	@Test
	public void testReadImage() {
		Image image = repository.findById(1L).get();

		File file = new File("/home/dhruv/Pictures/downloaded/" + image.getName());

		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(image.getData());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
