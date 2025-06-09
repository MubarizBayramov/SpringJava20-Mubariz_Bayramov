package az.devolopia.tourist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.tourist.exception.MyException;
import az.devolopia.tourist.request.BookingRequest;
import az.devolopia.tourist.request.CommentRequest;
import az.devolopia.tourist.request.RatingRequest;
import az.devolopia.tourist.request.TouristAddRequest;
import az.devolopia.tourist.response.BookingResponse;
import az.devolopia.tourist.response.ObjectSearchResponse;
import az.devolopia.tourist.response.TouristAddResponse;
import az.devolopia.tourist.service.TouristService;
import az.devolopia.tourist.util.Constants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tourists")
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    
    @GetMapping("/search")
    public ResponseEntity<List<ObjectSearchResponse>> searchObjects(
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        List<ObjectSearchResponse> result = touristService.searchObjects(address, minPrice, maxPrice);
        return ResponseEntity.ok(result);
    }

   
    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookObject(@Valid @RequestBody BookingRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        BookingResponse response = touristService.bookObject(req);
        return ResponseEntity.ok(response);
    }

   
    @PostMapping("/register")
    public ResponseEntity<TouristAddResponse> register(@Valid @RequestBody TouristAddRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        Integer id = touristService.addTourist(req);
        TouristAddResponse response = new TouristAddResponse();
        response.setId(id);
        return ResponseEntity.ok(response);
    }

   
    @PostMapping("/rate")
    public ResponseEntity<Void> rateObject(@Valid @RequestBody RatingRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        touristService.rateObject(req);
        return ResponseEntity.ok().build();
    }

   
    
    @PostMapping("/comment")
    public ResponseEntity<Void> commentOnObject(@Valid @RequestBody CommentRequest req, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }
        touristService.commentOnObject(req);
        return ResponseEntity.ok().build();
    }
}
