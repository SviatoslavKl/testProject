package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalendlyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @Size(max = 30)
    private String type;

    @Size(min = 2, max = 20)
    private String name;

    @Size(max = 255)
    private String description;

    @Min(1)
    private Integer duration;

    @Size(max = 50)
    private String slug;

    @Size(max = 20)
    private String color;

    private Boolean active;

    @NotNull(message="CreatedAt is required")
    private long createdAt;

    @NotNull(message="UpdatedAt is required")
    private long updatedAt;

    @Size(max = 255)
    private String url;

}
