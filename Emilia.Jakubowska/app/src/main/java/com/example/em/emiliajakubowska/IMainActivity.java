package com.example.em.emiliajakubowska;

import java.util.regex.Pattern;

/**
 * Created by Em on 2017-01-29.
 */

public interface IMainActivity {
    public static final Pattern EMAIL_ADDRESS_PATTERN =
            Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                            "\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                            "\\." +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            ")+"
            );
    public static final Pattern PASSWORD_PATTERN = Pattern
            .compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})");;
}
