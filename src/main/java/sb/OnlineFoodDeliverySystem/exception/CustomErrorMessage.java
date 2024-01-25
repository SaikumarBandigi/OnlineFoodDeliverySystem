package sb.OnlineFoodDeliverySystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomErrorMessage {

    private String msg;

    private LocalDate localDate;



}
