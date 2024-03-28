package scm.address.model.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Schedule in the address book.
 * <p>
 * Guarantees: details are present and not null, field values are validated.
 */
public class Schedule {
    private final Title title;
    private final Description description;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    /**
     * Constructs a {@code Schedule} with the specified title, description, start and end datetime.
     *
     * @param title       The schedule's title.
     * @param description The schedule's description.
     * @param startDateTime The schedule's start datetime.
     * @param endDateTime The schedule's end datetime.
     */
    public Schedule(Title title, Description description, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        assert title != null : "Title cannot be null";
        assert description != null : "Description cannot be null";
        assert startDateTime != null : "Start DateTime cannot be null";
        assert endDateTime != null : "End DateTime cannot be null";
        assert startDateTime.isBefore(endDateTime) : "Start DateTime must be before End DateTime";

        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s at %s", description, startDateTime.format(formatter));
    }
}
