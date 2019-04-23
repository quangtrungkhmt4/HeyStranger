package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.UserVerification;
import com.trung.HeyStranger.response.base.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVerificationResponse extends AbstractResponse {
    private UserVerification userVerification;
}