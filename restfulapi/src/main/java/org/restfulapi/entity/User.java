package org.restfulapi.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @author holy
 */
@Data
public class User {

    private @NonNull String username;

    private @NonNull String password;
}
