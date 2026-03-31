package org.traccar.protocol;

import org.junit.jupiter.api.Test;
import org.traccar.ProtocolTest;
import org.traccar.model.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UproProtocolEncoderTest extends ProtocolTest {

    @Test
    public void testEncodeEngineStop() throws Exception {
        var encoder = inject(new UproProtocolEncoder(null));
        Command command = new Command();
        command.setDeviceId(1);
        command.setType(Command.TYPE_ENGINE_STOP);
        command.set(Command.KEY_DEVICE_PASSWORD, "1234");
        assertEquals("LOCK,1234,CLOSE#", encoder.encodeCommand(command));
    }

    @Test
    public void testEncodeEngineResume() throws Exception {
        var encoder = inject(new UproProtocolEncoder(null));
        Command command = new Command();
        command.setDeviceId(1);
        command.setType(Command.TYPE_ENGINE_RESUME);
        command.set(Command.KEY_DEVICE_PASSWORD, "5678");
        assertEquals("LOCK,5678,OPEN#", encoder.encodeCommand(command));
    }

    @Test
    public void testEncodeCustom() throws Exception {
        var encoder = inject(new UproProtocolEncoder(null));
        Command command = new Command();
        command.setDeviceId(1);
        command.setType(Command.TYPE_CUSTOM);
        command.set(Command.KEY_DATA, "LOCK,9999,OPEN#");
        assertEquals("LOCK,9999,OPEN#", encoder.encodeCommand(command));
    }

}
