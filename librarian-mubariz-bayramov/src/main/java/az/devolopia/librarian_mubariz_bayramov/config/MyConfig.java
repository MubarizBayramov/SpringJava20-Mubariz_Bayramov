package az.devolopia.librarian_mubariz_bayramov.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import lombok.Data;


@Configuration
@Data
public class MyConfig {
	
	@Value(value = "${row.count.limit}")
	private Integer rowCountLimit;

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
