package az.devolopia.librarian_mubariz_bayramov.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentBookRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;

@Service
public class OverdueEmailService {

    private final StudentBookRepository studentBookRepository;
    private final StudentRepository studentRepository;
    private final JavaMailSender mailSender;

    public OverdueEmailService(StudentBookRepository studentBookRepository,
                               StudentRepository studentRepository,
                               JavaMailSender mailSender) {
        this.studentBookRepository = studentBookRepository;
        this.studentRepository = studentRepository;
        this.mailSender = mailSender;
    }

    // Hər gün avtomatik işə düşəcək
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendEmailsToOverdueStudents() {
        List<StudentBookEntity> overdueBooks = studentBookRepository.findOverdueBooks();

        for (StudentBookEntity sb : overdueBooks) {
            Optional<StudentEntity> studentOpt = studentRepository.findById(sb.getStudentId());

            if (studentOpt.isPresent()) {
                StudentEntity student = studentOpt.get();

                sendEmail(
                        student.getEmail(),
                        student.getName(),
                        sb.getDueDate()
                );
            }
        }
    }

    private void sendEmail(String to, String studentName, LocalDate dueDate) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Kitabın Qaytarılması Gecikib");
        message.setText("Hörmətli " + studentName + ",\n\n" +
                "Götürdüyünüz kitabın qaytarılma tarixi " + dueDate + " idi. Zəhmət olmasa kitabı ən qısa müddətdə qaytarın.\n\nTəşəkkürlər.");
        mailSender.send(message);
    }
}

