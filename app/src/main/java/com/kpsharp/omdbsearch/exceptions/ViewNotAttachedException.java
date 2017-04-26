package com.kpsharp.omdbsearch.exceptions;

public class ViewNotAttachedException extends RuntimeException {

    public ViewNotAttachedException() {
        super("This presenter does not have a view attached");
    }
}
