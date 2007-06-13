package org.lastbamboo.common.stun.stack.message.turn;

import java.net.InetSocketAddress;
import java.util.Map;

import org.apache.commons.id.uuid.UUID;
import org.lastbamboo.common.stun.stack.message.StunMessageType;
import org.lastbamboo.common.stun.stack.message.StunMessageVisitor;
import org.lastbamboo.common.stun.stack.message.attributes.StunAttribute;

/**
 * TURN send message for encapsulating data to be sent to remote hosts.
 */
public final class SendIndication extends AbstractStunDataMessage 
	{

    /**
     * Creates a new Send Indication message.
     * 
     * @param transactionId The ID of the transaction.
     * @param attributes The message attributes.
     */
    public SendIndication(final UUID transactionId, 
        final Map<Integer, StunAttribute> attributes)
        {
        super(transactionId, StunMessageType.SEND_INDICATION, attributes);
        }
    
    /**
     * Creates a new send indication message.
     * 
     * @param remoteAddress The address to send the data to.
     * @param data The data.
     */
    public SendIndication(final InetSocketAddress remoteAddress, 
        final byte[] data)
        {
        super(UUID.randomUUID(), StunMessageType.SEND_INDICATION, 
            data, remoteAddress);
        }
    
    public void accept(final StunMessageVisitor visitor)
        {
        visitor.visitSendIndication(this);
        }

    public boolean equals(final Object obj)
        {
        if (obj == this)
            {
            return true;
            }
        
        if (!(obj instanceof SendIndication))
            {
            return false;
            }
        
        final SendIndication request = (SendIndication) obj;

        return request.getAttributes().equals(getAttributes());
        }
    
    public int hashCode()
        {
        return 117*getAttributes().hashCode();
        }
	}
