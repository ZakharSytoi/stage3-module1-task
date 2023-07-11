package com.mjc.school.repository.data;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.util.DataReader;

import java.util.ArrayList;
import java.util.List;

public class AuthorData {
    private static final String AUTHORS_FILE_NAME = "authors";

    private static AuthorData instance;

    private final List<AuthorModel> authorList;

    private AuthorData() {
        authorList = new ArrayList<>();
        long i = 1;
        for (String str :
                DataReader.read(AUTHORS_FILE_NAME)) {
            authorList.add(new AuthorModel(i, str));
            i++;
        }
    }

    public static AuthorData getInstance() {
        if (instance == null) instance = new AuthorData();
        return instance;
    }

    public List<AuthorModel> getAuthorList() {
        return authorList;
    }
}
