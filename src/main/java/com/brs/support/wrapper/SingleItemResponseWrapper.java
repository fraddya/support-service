package com.brs.support.wrapper;

import com.brs.support.enums.RestApiResponseStatus;

/**
 * @author Nuwan
 */

public class SingleItemResponseWrapper<T> extends BaseResponseWrapper {

    private T content;


    //private HttpStatus status;

    /*public SingleItemResponseWrapper(T object, String status) {
        super(RestApiResponseStatus.OK);
        this.content = object;
        this.status = status;
    }*/

    public SingleItemResponseWrapper(T object, String message) {
        super(RestApiResponseStatus.OK);
        this.content = object;
        this.message = message;
    }

    public SingleItemResponseWrapper(T object) {
        super(RestApiResponseStatus.OK);
        this.content = object;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


}
