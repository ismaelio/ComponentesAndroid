package com.ismael.componentes;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ProgressBar progressBar;
	int progressStatus = 0;
	TextView textView;
	Button bt1, bt2, bt3;
	Handler handler = new Handler();
	ImageView img1,img2,img3,img4,img5;
	
	RadioButton rb1, rb2;
	CheckBox chk1, chk2;
	
	private static final String[] opa = {"Selecione uma opção","Donkey Kong Country", "Donkey Kong Country 2", "Donkey Kong Country 3"};
	ArrayAdapter<String>aopa;
	Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        inicio();
    }
    
    public void inicio(){
    	 setContentView(R.layout.activity_main);
    	progressBar = (ProgressBar)findViewById(R.id.progressBar1);
        textView = (TextView)findViewById(R.id.textView1);
        bt1 = (Button)findViewById(R.id.button1);
        img1 = (ImageView)findViewById(R.id.imageView1);
        
        //Comando para ocultar os objetos
           textView.setVisibility(View.INVISIBLE);
        img1.setVisibility(View.INVISIBLE);  
        
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				textView.setVisibility(View.VISIBLE);
		        img1.setVisibility(View.VISIBLE); 
		        
		        new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(progressStatus=0;progressStatus<=100;progressStatus++){
							//atualizar a barra de progresso
							handler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									progressBar.setProgress(progressStatus);
									if(progressStatus <= 12){
										textView.setText("Capa de Donkey Kong Country");
										img1.setImageResource(R.drawable.dkc1capa);
									}else if(progressStatus <= 24){
										textView.setText("Capa de Donkey Kong Country 2");
										img1.setImageResource(R.drawable.dkc2capa);
									}else if(progressStatus <= 36){
										textView.setText("Capa de Donkey Kong Country 3");
										img1.setImageResource(R.drawable.dkc3capa);
									}else if(progressStatus <= 48){
										textView.setText("Donkey Kong");
										img1.setImageResource(R.drawable.dkc1dk);
									}else if(progressStatus <= 60){
										textView.setText("Diddy Kong");
										img1.setImageResource(R.drawable.dkc1diddy);
									}else if(progressStatus <= 72){
										textView.setText("Dixie Kong");
										img1.setImageResource(R.drawable.dkc2dixie);
									}else if(progressStatus <= 84){
										textView.setText("Kiddy Kong");
										img1.setImageResource(R.drawable.dkc3kiddy);
									}else if(progressStatus <= 96){
										textView.setText("King K. Rool");
										img1.setImageResource(R.drawable.dkc1krool);
									}else if(progressStatus == progressBar.getMax()){
										tela1(); 
									} 
								}
							});
						try {
							//faz a barra inclementar em 100 milissegundos
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					}
				}).start();	        
			}
		}); 
        
    }
    public void tela1(){
    	setContentView(R.layout.menu);
    	img1 = (ImageView)findViewById(R.id.imageView1);
    	spin1 = (Spinner)findViewById(R.id.spinner1);
    	aopa = new ArrayAdapter<String>
    	(this, android.R.layout.simple_spinner_item, opa);
    	spin1.setAdapter(aopa);
   bt1 = (Button)findViewById(R.id.button1);
   bt2 = (Button)findViewById(R.id.Button01);
    	
   bt2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		inicio();
	}
});
   
   bt1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(spin1.getSelectedItemPosition()){
			case 1 :
				oo1();	
				break;
			case 2:
				oo2();
				break;
			case 3:
				oo3();
				break;
					
				default:
					AlertDialog.Builder dialogo = new
					AlertDialog.Builder(MainActivity.this);
					dialogo.setTitle("Atenção");
					dialogo.setMessage("Por favor, selecione uma opção");
					dialogo.setNeutralButton("ok", null);
					dialogo.show();
					break;
		
		}
		}
	});
	    
    }
    
    public void oo1(){
    	setContentView(R.layout.o1);
    	bt2 = (Button)findViewById(R.id.Button01);
    	img1 = (ImageView)findViewById(R.id.imageView1);
    	img2 = (ImageView)findViewById(R.id.imageView2);
    	
    	rb1 = (RadioButton)findViewById(R.id.radioButton1);
    	rb2 = (RadioButton)findViewById(R.id.radioButton2);
    	chk1 = (CheckBox)findViewById(R.id.checkBox1);
    	chk2 = (CheckBox)findViewById(R.id.checkBox2);
    	
    	img1.setVisibility(View.INVISIBLE);
    	img2.setVisibility(View.INVISIBLE);
    	
    	chk1.setVisibility(View.INVISIBLE);
    	chk2.setVisibility(View.INVISIBLE);
    	
    	 bt2.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				tela1();
    			}
    		});
    	 
    	 rb1.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				chk1.setText("Capa");
 				chk2.setText("Screenshot");
 				chk1.setVisibility(View.VISIBLE);
 				chk2.setVisibility(View.VISIBLE);
 				chk1.setChecked(false);
 				chk2.setChecked(false);
 				rb2.setChecked(false);
 				img1.setVisibility(View.INVISIBLE);
 		    	img2.setVisibility(View.INVISIBLE);
 				
 		    	chk1.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc1capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc1scr);
 							
 							
 							
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc1capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc1scr);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 			}
 		}); 
     	
    	 rb2.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				chk1.setText("Donkey Kong");
  				chk2.setText("Diddy Kong");
  				chk1.setVisibility(View.VISIBLE);
  				chk2.setVisibility(View.VISIBLE);
  				chk1.setChecked(false);
  				chk2.setChecked(false);
  				rb1.setChecked(false);
  				img1.setVisibility(View.INVISIBLE);
  		    	img2.setVisibility(View.INVISIBLE);
  				
  		    	chk1.setOnClickListener(new View.OnClickListener() {
  					
  					@Override
  					public void onClick(View arg0) {
  						// TODO Auto-generated method stub
  						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
  						if(chk1.isChecked()){
  							img1.setImageResource(R.drawable.dkc1dk);
  							
  							
  							
  							img1.setVisibility(View.VISIBLE);
  					    	
  					    	
  						} if(chk2.isChecked()){
  						
  							img2.setImageResource(R.drawable.dkc1diddy);
  							
  							
  							
  					    	img2.setVisibility(View.VISIBLE);
  					    	
  						}
  					}
  				});
  		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc1dk);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 						
 							img2.setImageResource(R.drawable.dkc1diddy);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
  			}
  		}); 
    
    }
    
    public void oo2(){
    	setContentView(R.layout.o2);
    	bt2 = (Button)findViewById(R.id.Button01);
    	img1 = (ImageView)findViewById(R.id.imageView1);
    	img2 = (ImageView)findViewById(R.id.imageView2);
    	
    	rb1 = (RadioButton)findViewById(R.id.radioButton1);
    	rb2 = (RadioButton)findViewById(R.id.radioButton2);
    	chk1 = (CheckBox)findViewById(R.id.checkBox1);
    	chk2 = (CheckBox)findViewById(R.id.checkBox2);
    	
    	img1.setVisibility(View.INVISIBLE);
    	img2.setVisibility(View.INVISIBLE);
    	
    	chk1.setVisibility(View.INVISIBLE);
    	chk2.setVisibility(View.INVISIBLE);
    	
    	 bt2.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				tela1();
    			}
    		});
    	 
    	 rb1.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				chk1.setText("Capa");
 				chk2.setText("Screenshot");
 				chk1.setVisibility(View.VISIBLE);
 				chk2.setVisibility(View.VISIBLE);
 				chk1.setChecked(false);
 				chk2.setChecked(false);
 				rb2.setChecked(false);
 				img1.setVisibility(View.INVISIBLE);
 		    	img2.setVisibility(View.INVISIBLE);
 				
 		    	chk1.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc2capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc2scr);
 							
 							
 							
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc2capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc2scr);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 			}
 		}); 
     	
    	 rb2.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				chk1.setText("Diddy Kong");
  				chk2.setText("Dixie Kong");
  				chk1.setVisibility(View.VISIBLE);
  				chk2.setVisibility(View.VISIBLE);
  				chk1.setChecked(false);
  				chk2.setChecked(false);
  				rb1.setChecked(false);
  				img1.setVisibility(View.INVISIBLE);
  		    	img2.setVisibility(View.INVISIBLE);
  				
  		    	chk1.setOnClickListener(new View.OnClickListener() {
  					
  					@Override
  					public void onClick(View arg0) {
  						// TODO Auto-generated method stub
  						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
  						if(chk1.isChecked()){
  							img1.setImageResource(R.drawable.dkc2diddy);
  							
  							
  							
  							img1.setVisibility(View.VISIBLE);
  					    	
  					    	
  						} if(chk2.isChecked()){
  						
  							img2.setImageResource(R.drawable.dkc2dixie);
  							
  							
  							
  					    	img2.setVisibility(View.VISIBLE);
  					    	
  						}
  					}
  				});
  		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc2diddy);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 						
 							img2.setImageResource(R.drawable.dkc2dixie);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
  			}
  		}); 
    }
    
    public void oo3(){
    	setContentView(R.layout.o3);
    	bt2 = (Button)findViewById(R.id.Button01);
    	img1 = (ImageView)findViewById(R.id.imageView1);
    	img2 = (ImageView)findViewById(R.id.imageView2);
    	
    	rb1 = (RadioButton)findViewById(R.id.radioButton1);
    	rb2 = (RadioButton)findViewById(R.id.radioButton2);
    	chk1 = (CheckBox)findViewById(R.id.checkBox1);
    	chk2 = (CheckBox)findViewById(R.id.checkBox2);
    	
    	img1.setVisibility(View.INVISIBLE);
    	img2.setVisibility(View.INVISIBLE);
    	
    	chk1.setVisibility(View.INVISIBLE);
    	chk2.setVisibility(View.INVISIBLE);
    	
    	 bt2.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				tela1();
    			}
    		});
    	 
    	 rb1.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				chk1.setText("Capa");
 				chk2.setText("Screenshot");
 				chk1.setVisibility(View.VISIBLE);
 				chk2.setVisibility(View.VISIBLE);
 				chk1.setChecked(false);
 				chk2.setChecked(false);
 				rb2.setChecked(false);
 				img1.setVisibility(View.INVISIBLE);
 		    	img2.setVisibility(View.INVISIBLE);
 				
 		    	chk1.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc3capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc3scr);
 							
 							
 							
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc3capa);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 							
 							img2.setImageResource(R.drawable.dkc3scr);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
 			}
 		}); 
     	
    	 rb2.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				chk1.setText("Dixie Kong");
  				chk2.setText("Kiddy Kong");
  				chk1.setVisibility(View.VISIBLE);
  				chk2.setVisibility(View.VISIBLE);
  				chk1.setChecked(false);
  				chk2.setChecked(false);
  				rb1.setChecked(false);
  				img1.setVisibility(View.INVISIBLE);
  		    	img2.setVisibility(View.INVISIBLE);
  				
  		    	chk1.setOnClickListener(new View.OnClickListener() {
  					
  					@Override
  					public void onClick(View arg0) {
  						// TODO Auto-generated method stub
  						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
  						if(chk1.isChecked()){
  							img1.setImageResource(R.drawable.dkc3dixie);
  							
  							
  							
  							img1.setVisibility(View.VISIBLE);
  					    	
  					    	
  						} if(chk2.isChecked()){
  						
  							img2.setImageResource(R.drawable.dkc3kiddy);
  							
  							
  							
  					    	img2.setVisibility(View.VISIBLE);
  					    	
  						}
  					}
  				});
  		    	
chk2.setOnClickListener(new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View arg0) {
 						// TODO Auto-generated method stub
 						img1.setVisibility(View.INVISIBLE);
  						img2.setVisibility(View.INVISIBLE);
 						if(chk1.isChecked()){
 							img1.setImageResource(R.drawable.dkc3dixie);
 							
 							
 							
 							img1.setVisibility(View.VISIBLE);
 					    	
 					    	
 						} if(chk2.isChecked()){
 						
 							img2.setImageResource(R.drawable.dkc3kiddy);
 							
 							
 						
 					    	img2.setVisibility(View.VISIBLE);
 					    	
 						}
 					}
 				});
  			}
  		}); 
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

