package tests.lesson_21.model;

import lombok.Data;

@Data
public class CreateTestCaseResponse {
    Integer id;
    String name, statusName, statusColor;
    Boolean automated, external;
    Long createdDate;
}
