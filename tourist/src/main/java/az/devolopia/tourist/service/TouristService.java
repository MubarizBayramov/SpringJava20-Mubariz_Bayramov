
package az.devolopia.tourist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import az.devolopia.tourist.entity.BookingEntity;
import az.devolopia.tourist.entity.CommentEntity;
import az.devolopia.tourist.entity.ObjectEntity;
import az.devolopia.tourist.entity.RatingEntity;
import az.devolopia.tourist.entity.TouristEntity;
import az.devolopia.tourist.exception.MyException;
import az.devolopia.tourist.repository.BookingRepository;
import az.devolopia.tourist.repository.CommentRepository;
import az.devolopia.tourist.repository.ObjectRepository;
import az.devolopia.tourist.repository.RatingRepository;
import az.devolopia.tourist.repository.TouristRepository;
import az.devolopia.tourist.request.BookingRequest;
import az.devolopia.tourist.request.CommentRequest;
import az.devolopia.tourist.request.RatingRequest;
import az.devolopia.tourist.request.TouristAddRequest;
import az.devolopia.tourist.response.BookingResponse;
import az.devolopia.tourist.response.ObjectSearchResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TouristService {

    private final TouristRepository touristRepository;
    private final ObjectRepository objectRepository;
    private final BookingRepository bookingRepository;
    private final RatingRepository ratingRepository;
    private final CommentRepository commentRepository;

    // 1. Search objects
    public List<ObjectSearchResponse> searchObjects(String address, Double minPrice, Double maxPrice) {
        List<ObjectEntity> objects = objectRepository.findByAddressAndPriceRange(address, minPrice, maxPrice);
        return objects.stream().map(obj -> {
            ObjectSearchResponse resp = new ObjectSearchResponse();
            resp.setId(obj.getId());
            resp.setName(obj.getName());
            resp.setPricePerNight(obj.getPricePerNight());
            resp.setAddress(obj.getAddress());
            resp.setAvgRating(obj.getAverageRating());
            resp.setCommentCount(obj.getComments().size());
            return resp;
        }).collect(Collectors.toList());
    }


    // 2. Book object
    public BookingResponse bookObject(BookingRequest req) {
        ObjectEntity object = objectRepository.findById(req.getObjectId())
                .orElseThrow(() -> new MyException("Object not found", null, null));
        // Check availability
        boolean overlap = bookingRepository.existsByObjectIdAndDateRange(
                req.getObjectId(), req.getStartDate(), req.getEndDate());
        if (overlap) {
            throw new MyException("Object is already booked for selected dates", null, null);
        }
        BookingEntity booking = new BookingEntity();
        booking.setObject(object);
        booking.setTouristId(req.getTouristId());
        booking.setStartDate(req.getStartDate());
        booking.setEndDate(req.getEndDate());
        bookingRepository.save(booking);
        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        return response;
    }
    

    // 3. Register tourist
    public Integer addTourist(TouristAddRequest req) {
        TouristEntity entity = new TouristEntity();
        entity.setName(req.getName());
        entity.setSurname(req.getSurname());
        entity.setEmail(req.getEmail());
        entity.setPhone(req.getPhone());
        entity.setBirthday(req.getBirthday());
        return touristRepository.save(entity).getId();
    }

    
    
    // 4. Rate object
    public void rateObject(RatingRequest req) {
        ObjectEntity object = objectRepository.findById(req.getObjectId())
                .orElseThrow(() -> new MyException("Object not found", null, null));
        RatingEntity rating = new RatingEntity();
        rating.setObject(object);
        rating.setTouristId(req.getTouristId());
        rating.setScore(req.getScore());
        ratingRepository.save(rating);
    }

    
    // 5. Comment on object
    public void commentOnObject(CommentRequest req) {
        ObjectEntity object = objectRepository.findById(req.getObjectId())
                .orElseThrow(() -> new MyException("Object not found", null, null));
        CommentEntity comment = new CommentEntity();
        comment.setObject(object);
        comment.setTouristId(req.getTouristId());
        comment.setContent(req.getContent());
        commentRepository.save(comment);
    }
}





