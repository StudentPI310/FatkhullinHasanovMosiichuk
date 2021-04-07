public class Prodact {
	private int kolvo;
    private int price;
    private int proiz;
    private String name;
    public int getKolvo(){return this.kolvo;}
    public int getPrice(){return this.price;}
    public int getProiz(){return this.proiz;}
    public void setKolvo(int a){this.kolvo=a;}
    public void setPrice(int a){this.price=a;}
    public void setProiz(int a){this.proiz=a;}
    
   

    public String getName(){return this.name;}
    public void setName(String a){this.name = a;}
    

    public Prodact (int k,int p,String s){
    	this.setKolvo(k);
    	this.setPrice(p);
        this.setName(s);
        this.setProiz(p*k);
        
        
        
        

    }
    
}
