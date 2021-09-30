package es.jguimar.tinybankAPI.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

   // @Id
    private String id;

    private List<String> userIds;

    private List<Double> movements;

    private Double totalAmount;

    public void updateTotalAmount() {
        totalAmount = movements.stream().reduce(0.0, Double::sum);
    }


}
