package az.devolopia.tourist.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectListResponse {
	
	private List<ObjectSingleResponse> objects;
	private Long totalSize;

}
