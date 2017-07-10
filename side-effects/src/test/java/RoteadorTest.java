/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class RoteadorTest {
    @Test public void testRoteador() {
        Mensagem msgPar = new Mensagem(42, "não entre em panico");
        Mensagem msgImpar = new Mensagem(67, "elementar, meu caro watson");

        Gravador gravadorPar = new Gravador();
        Gravador gravadorImpar = new Gravador();

        Roteador roteador = new Roteador(gravadorPar, gravadorImpar);

        roteador.processar(msgPar);
        roteador.processar(msgImpar);

        assertEquals(1, gravadorPar.mensagens().size());
        assertEquals(msgPar, gravadorPar.mensagens().get(0));
        assertEquals(msgImpar, gravadorImpar.mensagens().get(0));
    }

    class Gravador implements Processador {
        List<Mensagem> msgs = new ArrayList<Mensagem>();

        public void processar(Mensagem msg) {
            msgs.add(msg);
        }

        public List<Mensagem> mensagens() {
            return msgs;
        }
    }
}
