package com.mjc.school.repository.data;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.util.DataReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AuthorData {

    private static final String AUTHORS_FILE_NAME = "module-repository/src/main/resources/authors";

    private static AuthorData instance;

    private final List<AuthorModel> authorList;

    private AuthorData() {
        authorList = new ArrayList<>();
        long i = 1;
        for (String str :
                DataReader.read(new File(AUTHORS_FILE_NAME))) {
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
