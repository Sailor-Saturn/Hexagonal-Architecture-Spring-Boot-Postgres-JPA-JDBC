package utils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public abstract class RandomUUID {
    @NotNull
    @Size(min = 5, max = 10)
    public final String id;

    public RandomUUID() {
        this.id = String.format(UUID.randomUUID().toString());
    }

    public RandomUUID(String id) {
        this.id = id;
    }

    public boolean sameValueAs(RandomUUID other) {
        return other != null && this.id.equals(other.id);
    }
}