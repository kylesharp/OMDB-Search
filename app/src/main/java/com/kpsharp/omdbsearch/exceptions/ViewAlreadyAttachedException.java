package com.kpsharp.omdbsearch.exceptions;

public class ViewAlreadyAttachedException extends RuntimeException {

    public ViewAlreadyAttachedException() {
        super("This presenter is already has a view attached");
    }
}
