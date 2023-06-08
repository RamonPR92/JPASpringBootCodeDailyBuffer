package com.ramon.jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * When two or more classes make one table, we should use @Embeddable, @Embedded, @AttributeOverrides
 * and @AttributeOverride annotations for arrive to this situation
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        //Here we say that class attribute is representing or is linked with our table attribute
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
