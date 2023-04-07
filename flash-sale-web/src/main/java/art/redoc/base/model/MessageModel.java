package art.redoc.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    public MessageModel(String message) {
        this.message = message;
    }

    private String message;
}
