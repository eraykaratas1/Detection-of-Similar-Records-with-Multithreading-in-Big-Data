
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Product implements Runnable{

   private ArrayList<String> product;
   private int thread_value;
   private ArrayList<String> product_data;
   

    public Product(ArrayList<String> product,int thread_value,ArrayList<String> product_data) {
        this.product = product;
        this.thread_value=thread_value;
        this.product_data=product_data;
    } 
    
  
    
    @Override
    public void run() {
           
        System.out.println("Thread "+thread_value+" calismaya basladi");   
        

        for (int i=1;i<product.size();i++) {  // diger kayitlarda aranacak kayit
            
            String x=product.get(i);    // aranacak kayit
            
            String []str=x.split(" ");
            

            for (int j=thread_value*10000+1-10000;j<thread_value*10000; j++) {  // diger kayitlar
            
              // 1.kayıtta 2.kayıttan basla,2.kayıtta 3.kayıttan basla,3.kayıtta 4.kayıttan basla
                 
               String y=product.get(j);   // kiyaslanacak kayit
             
             String []str2=y.split(" ");
             
                float l1=0;
             for(int k=0;k<str.length;k++){
             
                if(y.contains(str[k])){  // 1.kayıttaki kelimeler diger kayitlarda var mi kontrolu yapilir
                 
                   l1++;  // varsa benzer kelime sayisini 1 arttir
        
           }
                
             }
             float similar;
             
         if(str.length>=str2.length){
             
           similar=(l1/str.length)*100;     //str nin boyutu str 2 den daha buyukse payda str olur,kayitlar arasindaki benzerlik orani 
            
            String d1=String.valueOf(i);
            String d2=String.valueOf(j);
            
            String sim1=String.valueOf(similar);
            
            product_data.add(d1);
            product_data.add(x);  // aranacak kayıt
            
            product_data.add(d2);
            product_data.add(y);  // kıyaslanacak kayıt
            
            product_data.add(sim1);  // benzerlik oranı
            
            
  
         }    
         else{  
         
             similar=(l1/str2.length)*100;  //str2 nin boyutu str den daha buyukse payda str2 olur,kayitlar arasindaki benzerlik orani
                
            String d1=String.valueOf(i);
            String d2=String.valueOf(j);
            
            String sim1=String.valueOf(similar);
            
            product_data.add(d1);  // aranacak kayidin sirasi
            product_data.add(x);  // aranacak kayıt
            
            product_data.add(d2); // kiyaslanacak kayidin sirasi
            product_data.add(y);  // kıyaslanacak kayıt
            
            product_data.add(sim1);  // benzerlik oranı
         }

         System.out.println("Product Sutunundaki "+i+".ci kayit ile "+j+".ci kayit arasindaki benzerlik orani:%"+similar); 

        
                    
                }
    
        
                    System.out.println("Thread "+thread_value+" "+"isini bitirdi");  
                    
                  if(i==10){  
                     break;
                  }
                        
        }
        

    }
    



  
    
    
    
    
    
    
}
