package uz.jurayev.academy.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
