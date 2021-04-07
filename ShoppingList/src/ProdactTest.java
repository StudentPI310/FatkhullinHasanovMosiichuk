import org.junit.Test;

import static org.junit.Assert.*;



public class ProdactTest {
    @Test    
    public void getProiz() throws Exception {
        Prodact testProd = new Prodact(3,4,"test");
        assertTrue(testProd.getProiz()==12);
        }

    

}
