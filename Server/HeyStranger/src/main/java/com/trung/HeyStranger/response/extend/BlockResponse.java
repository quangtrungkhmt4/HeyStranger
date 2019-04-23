package com.trung.HeyStranger.response.extend;

import com.trung.HeyStranger.model.BlockList;
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
public class BlockResponse extends AbstractResponse {
    private BlockList blockList;
}
