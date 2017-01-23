package com.wow.mailutils;

import java.util.List;

/**
 * Created by kisrosen on 17/1/11.
 */
public class MailContent {
    /**
     * Mail Title
     */
    private String title;

    /**
     * Mail Destination List
     */
    private List<String> toNames;

    /**
     * Mail Copyto List
     */
    private List<String> ccNames;
}
