package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import exercitiul2.PerecheNumere;
public class TestePerecheNumere {
    @Test
    void testSumaCifreEgala1(){
        PerecheNumere nrs = new PerecheNumere(123,213);
        assertTrue(nrs.sumaCifEgala());
    }
    @Test
    void testSumaCifreEgala2(){
        PerecheNumere nrs = new PerecheNumere(12,98);
        assertFalse(nrs.sumaCifEgala());
    }
    @Test
    void testSumaCifreEgala3(){
        PerecheNumere nrs = new PerecheNumere(-111,12);
        assertTrue(nrs.sumaCifEgala());
    }

    @Test
    void testNrCifrePare1(){
        PerecheNumere nrs = new PerecheNumere(426,862);
        assertTrue(nrs.nrCifrePare());
    }
    @Test
    void testNrCifrePare2(){
        PerecheNumere nrs = new PerecheNumere(1248,862);
        assertFalse(nrs.nrCifrePare());
    }
    @Test
    void testNrCifrePare3(){
        PerecheNumere nrs = new PerecheNumere(0,2);
        assertTrue(nrs.nrCifrePare());
    }
    @Test
    void test_suntConsecutiveFibonnaci1() {
        PerecheNumere nrs = new PerecheNumere(5,8);
        assertTrue(nrs.suntConsecutiveFibonnaci());
    }

    @Test
    void test_suntConsecutiveFibonnaci2() {
        PerecheNumere nrs = new PerecheNumere(5, 9);
        assertFalse(nrs.suntConsecutiveFibonnaci());
    }

    @Test
    void test3_suntConsecutiveFibonnaci3() {
        PerecheNumere nrs = new PerecheNumere(1, 1);
        assertTrue(nrs.suntConsecutiveFibonnaci());
    }

    @Test
    void test_celMaiMicMultipluComun1() {
        PerecheNumere nrs = new PerecheNumere(12, 18);
        assertEquals(36, nrs.celMaiMicMultipluComun());
    }

    @Test
    void test_celMaiMicMultipluComun2() {
        PerecheNumere nrs = new PerecheNumere(7, 0);
        assertEquals(0, nrs.celMaiMicMultipluComun());
    }

    @Test
    void test_celMaiMicMultipluComun3() {
        PerecheNumere nrs = new PerecheNumere(8, 20);
        assertEquals(40, nrs.celMaiMicMultipluComun());
    }
}
