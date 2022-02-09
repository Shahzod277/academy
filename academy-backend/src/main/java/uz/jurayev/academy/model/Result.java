package uz.jurayev.academy.model;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String message;
    private Boolean success;

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
