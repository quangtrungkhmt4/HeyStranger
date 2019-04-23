package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.AbstractModel;
import com.trung.HeyStranger.model.Activity;
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
public class ActivityListResponse extends AbstractModel {
    List<Activity> activities;
}
