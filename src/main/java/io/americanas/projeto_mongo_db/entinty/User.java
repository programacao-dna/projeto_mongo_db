package io.americanas.projeto_mongo_db.entinty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "users")
public class User {

    @Id
    private String id;

    @Length(min = 10, max = 50)
    @Pattern(regexp = "^[^\\s]+$", message = "Username não pode conter espaços entre palavras.")
    @NotBlank(message = "Campo obrigatório")
//    @Indexed(unique = true)
    private String username;

    @Email(message = "O campo deve conter um email valido.")
    @NotBlank(message = "Campo obrigatório")
    private String email;

    @Pattern(regexp = "^[0-9]+$", message = "Deve conter apenas números")
    @NotBlank(message = "Campo obrigatório")
    private String phone;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private String password;


    public User(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}

