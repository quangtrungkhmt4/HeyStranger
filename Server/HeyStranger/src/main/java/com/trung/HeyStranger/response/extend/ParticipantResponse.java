package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.Participant;
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
public class ParticipantResponse extends AbstractResponse {
    private Participant participant;
}
