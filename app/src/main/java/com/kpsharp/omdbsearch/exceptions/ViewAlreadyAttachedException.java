package com.kpsharp.omdbsearch.exceptions;

/**
 * Used for MVP architecture for when we try to attach a view to a presenter that has a view
 */
public class ViewAlreadyAttachedException extends RuntimeException {

    public ViewAlreadyAttachedException() {
        super("This presenter is already has a view attached");
    }
}
