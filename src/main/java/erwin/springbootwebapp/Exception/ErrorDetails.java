package erwin.springbootwebapp.Exception;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ErrorDetails {
    private final String message;
    private final String details;
    private final LocalDate timestamp;

    public ErrorDetails(String message, String details, LocalDate timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }
}
