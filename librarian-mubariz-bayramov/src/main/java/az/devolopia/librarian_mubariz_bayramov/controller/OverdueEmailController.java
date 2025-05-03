package az.devolopia.librarian_mubariz_bayramov.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.service.OverdueEmailService;

@RestController
@RequestMapping("/api/emails")
public class OverdueEmailController {

    private final OverdueEmailService overdueEmailService;

    public OverdueEmailController(OverdueEmailService overdueEmailService) {
        this.overdueEmailService = overdueEmailService;
    }

    @PostMapping("/send-overdue")
    public ResponseEntity<String> sendOverdueEmails() {
        overdueEmailService.sendEmailsToOverdueStudents();
        return ResponseEntity.ok("Gecikdirən tələbələrə email göndərildi.");
    }

    // Gecikən tələbələrə e-mailləri hər gün saat 9:00-da göndər
    @Scheduled(cron = "0 0 9 * * ?")
    public void scheduledSendOverdueEmails() {
        overdueEmailService.sendEmailsToOverdueStudents();
        System.out.println("Gecikdirən tələbələrə avtomatik email göndərildi.");
    }
}

