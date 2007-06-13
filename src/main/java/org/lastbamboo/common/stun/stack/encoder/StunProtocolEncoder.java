package org.lastbamboo.common.stun.stack.encoder;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.lastbamboo.common.stun.stack.message.StunMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encodes bytes into STUN messages.
 */
public class StunProtocolEncoder implements ProtocolEncoder
    {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public void dispose(final IoSession session) throws Exception
        {
        // TODO Auto-generated method stub

        }

    public void encode(final IoSession session, final Object message,
        final ProtocolEncoderOutput out) throws Exception
        {
        LOG.debug("{} encoding message: {}", this, message);
        final StunMessageEncoder encoder = new StunMessageEncoder();
        
        final StunMessage stunMessage = (StunMessage) message;
        final ByteBuffer buf = encoder.encode(stunMessage);
        out.write(buf);
        }
    }
