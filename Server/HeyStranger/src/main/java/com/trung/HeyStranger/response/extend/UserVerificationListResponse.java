package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.UserVerification;
import com.trung.HeyStranger.response.base.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVerificationListResponse extends AbstractResponse {
    private List<UserVerification> userVerifications;
}