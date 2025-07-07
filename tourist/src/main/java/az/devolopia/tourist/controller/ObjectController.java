package az.devolopia.tourist.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.tourist.exception.MyException;
import az.devolopia.tourist.request.ObjectAddRequest;
import az.devolopia.tourist.request.ObjectFilterRequest;
import az.devolopia.tourist.request.ObjectUpdateRequest;
import az.devolopia.tourist.response.ObjectAddResponse;
import az.devolopia.tourist.response.ObjectListResponse;
import az.devolopia.tourist.response.ObjectSingleResponse;
import az.devolopia.tourist.service.ObjectService;
import az.devolopia.tourist.util.Constants;
import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/objects")
public class ObjectController {

	@Autowired
	private ObjectService service;

	
	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_OBJECT')") //Yeni bir obyekt əlavə edir
	public ResponseEntity<ObjectAddResponse> add(@Valid @RequestBody ObjectAddRequest req, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		} else {
		ObjectAddResponse resp = service.add(req);
		return new ResponseEntity<ObjectAddResponse>(resp, HttpStatus.CREATED);
	}
		
	}
	

	@GetMapping(path = "/search") // Sistemə daxil edilmiş obyektləri ad, ünvan və ya digər açar sözlərlə axtarır.
	@PreAuthorize("hasAuthority('ROLE_SEARCH_OBJECT')")
	public ResponseEntity<ObjectListResponse> findAllSearch(@RequestParam(name = "query") String query) {
	    ObjectListResponse resp = service.findAllSearch(query);
	    return ResponseEntity.ok(resp);
	}

	
	
   
	@DeleteMapping(path = "/{id}") //Mövcud bir obyektin sistemdən silinməsi.
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_OBJECT')")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

	@GetMapping(path = "/{id}") //Verilən id-yə əsasən obyektin tam detalları qaytarılır.
	@PreAuthorize(value = "hasAuthority('ROLE_GET_OBJECT')")
	public ObjectSingleResponse findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	
	@PostMapping(path = "/filter") // İrəli səviyyəli axtarış 
	@PreAuthorize(value = "hasAuthority('ROLE_SEARCH_OBJECT')")
	public ResponseEntity<ObjectListResponse> findAllSearchFilter(@RequestBody ObjectFilterRequest req) {
		ObjectListResponse resp = service.findAllSearchFilter(req);
		return new ResponseEntity<ObjectListResponse>(resp, HttpStatus.OK);
	}
	
	
	

	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_EDIT_OBJECT')") // Mövcud obyektin məlumatlarını redaktə edir.
	public ResponseEntity<?> update(@Valid @RequestBody ObjectUpdateRequest u, BindingResult br) {
		if (br.hasErrors()) {
			throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
		}
		service.update(u);
		return ResponseEntity.ok().build();
	}
	
	
		}






