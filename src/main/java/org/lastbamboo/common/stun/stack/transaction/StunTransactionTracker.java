package org.lastbamboo.common.stun.stack.transaction;

import org.lastbamboo.common.stun.stack.message.StunMessage;

/**
 * Interface for classes responsible for keeping track of SIP transactions.
 */
public interface StunTransactionTracker
    {

    /**
     * Tells the tracker to start tracking the specified transaction.
     * 
     * @param ct The transaction to track.
     */
    void trackTransaction(StunClientTransaction ct);

    /**
     * Accessor for the client transcaction associated with the specified
     * message.
     * 
     * @param message The message containing a branch ID and SIP method to use
     * as a key for looking up the associated tranction.
     * @return The transaction associated with the specified message, or 
     * <code>null</code> if there is no associated transaction.  This can
     * happen if the transaction has timed out, for example.
     */
    StunClientTransaction getClientTransaction(StunMessage message);

    }
