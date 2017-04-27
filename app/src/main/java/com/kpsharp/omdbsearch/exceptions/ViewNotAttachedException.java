package com.kpsharp.omdbsearch.exceptions;

/**
 * Used for MVP architecture for when we try to get a view from a presenter that does not have one attached
 */
public class ViewNotAttachedException extends RuntimeException {

    public ViewNotAttachedException() {
        super("This presenter does not have a view attached");
    }
}
