package org.nuxeo.ide.qatests.dialogs;


public interface DialogOperation<T extends DialogBot> {
    
    /**
     * when opening the dialog the shell can be null
     * */
    void run(T dialog);
}
