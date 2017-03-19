package test.java.com.importsource.tuts.nio.selector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class EchoTest {
 
    Process server;
    EchoClient client;
 
    @Before
    public void setup() throws IOException, InterruptedException {
       // server = EchoServer.start();
        client = EchoClient.start();
    }
 
    @Test
    public void givenServerClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        for (int i = 0; i < 1000; i++) {
            String resp3 = client.sendMessage("world");
            assertEquals("world", resp3);
        }

        assertEquals("hello", resp1);
        assertEquals("world", resp2);

    }
 
    @After
    public void teardown() throws IOException {
      //  server.destroy();
        EchoClient.stop();
    }
}