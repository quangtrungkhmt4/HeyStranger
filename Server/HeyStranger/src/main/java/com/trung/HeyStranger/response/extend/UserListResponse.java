package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.User;
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
public class UserListResponse extends AbstractResponse {

    private List<User> users;
}
