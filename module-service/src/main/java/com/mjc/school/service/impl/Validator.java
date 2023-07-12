package com.mjc.school.service.impl;

import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.service.exception.ExceptionConstants.*;

class Validator {

    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_CONTENT_LENGTH = 255;
    private static final int MIN_CONTENT_LENGTH = 5;
    private static final int MAX_AUTHOR_ID = 30;


    public static void validateAuthorId(long id) {
        if (id <= 0 || id > MAX_AUTHOR_ID) {
            throw new ValidatorException(String.format(AUTHOR_ID_DOES_NOT_EXIST.getCodeMsg(), id));
        }
    }

    public static void validateNewsId(long id) {
        if (id <= 0){
            throw new ValidatorException(String.format(NEWS_ID_DOES_NOT_EXIST.getCodeMsg(), id));
        }
    }

    private static void validateString(String str, String validationType, int minLength, int maxLength) {
        if(str == null){
            throw new ValidatorException(String.format(NULL_STRING_EXCEPTION.getCodeMsg(), validationType));
        }
        if(str.length() < minLength || str.length() > maxLength){
            throw new ValidatorException(String.format(STRING_LENGTH_OUT_OF_RANGE.getCodeMsg(), validationType, minLength, maxLength, validationType, str));
        }
    }

    public static void validateDtoRequest(NewsDtoRequest request) {
        validateString(request.title(), "News title",MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
        validateString(request.content(), "News content", MIN_CONTENT_LENGTH, MAX_CONTENT_LENGTH);
        validateNewsId(request.id());
        validateAuthorId(request.authorId());
    }


}
