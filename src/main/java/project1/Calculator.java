package project1;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public class Calculator {

	static Text    txtResult;                              // 이미지 버튼
	static Button  btnNumber[]= new Button[10];  // 0~9 숫자
	static Button  btnSum, btnMinus, btnMulti, btnDiv;     // 차례대로 +, -, x, /
	static Button  btnEqual, btnClear, btnDot;             // 차례대로 =, clear, .
	
	static String input_number="";                           // 입력 값
	static double result_number;                          // 결과 값
    static String  oper;                        // 사칙연산
    static int tmpI;
    
	static Composite comp ;

	public static void main(String[] args) {
		Display display;
		Shell shell;
	
		display = new Display();
		shell = new Shell(display);
		shell.setSize(460, 720);
		shell.setText("Calculator");
		shell.setLayout(new FillLayout());
		
		createView(shell);
		Button();
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
	}

	private static void createView(Shell shell) {

		comp = new Composite(shell, SWT.NONE);
		comp.setLayout(new GridLayout(4, false));
	

		 GridData gridData = new GridData(GridData.FILL_BOTH);
	     gridData.horizontalSpan = 4;
	     
	     txtResult = new Text(comp, SWT.BORDER|SWT.RIGHT);
	     txtResult.setLayoutData(gridData);
	      
	        
        GridData gData = new GridData(GridData.FILL_BOTH);
        
        GridData gDataH = new GridData(GridData.FILL_BOTH);
        gDataH.horizontalSpan = 2;
        
        GridData gDataV= new GridData(GridData.FILL_BOTH);
        gDataV.verticalSpan = 2;
		
        btnClear        = new Button(comp, SWT.PUSH);
        btnClear        .setLayoutData(gDataH);
        btnClear        .setText("Clear");
        
        
        btnDiv          = new Button(comp, SWT.PUSH);
        btnDiv          .setLayoutData(gData);
        btnDiv          .setText("/");
        
        btnMulti        = new Button(comp, SWT.PUSH);
        btnMulti        .setLayoutData(gData);
        btnMulti        .setText("x");
        
        btnNumber[7]    = new Button(comp, SWT.PUSH);
        btnNumber[7]    .setLayoutData(gData);
        btnNumber[7]    .setText("7");
        
        btnNumber[8]    = new Button(comp, SWT.PUSH);
        btnNumber[8]    .setLayoutData(gData);
        btnNumber[8]    .setText("8");
        
        btnNumber[9]    = new Button(comp, SWT.PUSH);
        btnNumber[9]    .setLayoutData(gData);
        btnNumber[9]    .setText("9");
        
        btnMinus        = new Button(comp, SWT.PUSH);
        btnMinus        .setLayoutData(gData);
        btnMinus        .setText("-");
        
        btnNumber[4]    = new Button(comp, SWT.PUSH);
        btnNumber[4]    .setLayoutData(gData);
        btnNumber[4]    .setText("4");
        
        btnNumber[5]    = new Button(comp, SWT.PUSH);
        btnNumber[5]    .setLayoutData(gData);
        btnNumber[5]    .setText("5");
        
        btnNumber[6]    = new Button(comp, SWT.PUSH);
        btnNumber[6]    .setLayoutData(gData);
        btnNumber[6]    .setText("6");
        
        btnSum          = new Button(comp, SWT.PUSH);
        btnSum          .setLayoutData(gData);
        btnSum          .setText("+");
        
        btnNumber[1]    = new Button(comp, SWT.PUSH);
        btnNumber[1]    .setLayoutData(gData);
        btnNumber[1]    .setText("1");
        
        btnNumber[2]    = new Button(comp, SWT.PUSH);
        btnNumber[2]    .setLayoutData(gData);
        btnNumber[2]    .setText("2");
        
        btnNumber[3]    = new Button(comp, SWT.PUSH);
        btnNumber[3]    .setLayoutData(gData);
        btnNumber[3]    .setText("3");
        
        btnEqual        = new Button(comp, SWT.PUSH);
        btnEqual        .setLayoutData(gDataV);
        btnEqual        .setText("=");
        
        btnNumber[0]    = new Button(comp, SWT.PUSH);
        btnNumber[0]    .setLayoutData(gDataH);
        btnNumber[0]    .setText("0");
        
        btnDot          = new Button(comp, SWT.PUSH);
        btnDot          .setLayoutData(gData);
        btnDot          .setText(".");


		
	}
	
	private static void Button() {
		
		int length = btnNumber.length;
        
		for (int i = 0; i < length; i++) {
		    final int number = i;
		    btnNumber[i].addListener(SWT.Selection, new Listener() {

		        @Override
		        public void handleEvent(Event event) {
		            // TODO Auto-generated method stub
		           
		           input_number += number;
		           Double tmp = Double.parseDouble(input_number);
		           if(tmp%1==0) {
		        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
		        	   txtResult.setText(tmpI + "");
		           }else {
		        	   txtResult.setText(tmp + "");
		           }
		        }
		                
		     });
		    
		}
		btnDot.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	input_number+=".";
		    }
		});
		
		
		btnSum.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		        result_number += Double.parseDouble(input_number);
		        Double tmp = Double.parseDouble(input_number);
		        if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }
		        
		        oper = "+";
		        input_number = "0";
		        
		    }
		    
		});
		btnMinus.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		        result_number += Integer.parseInt(input_number);
		        
		        Double tmp = Double.parseDouble(input_number);
		        if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }
		        oper = "-";
		        input_number = "0";
		        
		    }
		    
		});
		btnMulti.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		        result_number += Integer.parseInt(input_number);
		        
		        Double tmp = Double.parseDouble(input_number);
		        if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }
		        
		        oper = "*";
		        input_number = "0";
		        
		    }
		    
		});
		btnDiv.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		        result_number += Integer.parseInt(input_number);
		        
		        Double tmp = Double.parseDouble(input_number);
		        if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }
		        
		        oper = "/";
		        input_number = "0";
		        
		    }
		    
		});
		btnEqual.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub

		        if (oper == "+") {
		            result_number += Double.parseDouble(input_number);
		            input_number = "0";
		        }
		        if (oper == "-") {
		            result_number -= Double.parseDouble(input_number);
		            input_number = "0";
		        }
		        if (oper == "*") {
		            result_number *= Double.parseDouble(input_number);
		            input_number = "0";
		        }
		        if (oper == "/") {
		            result_number /= Double.parseDouble(input_number);
		            input_number = "0";
		        }

		        
		        if(result_number%1==0) {
		        	   tmpI=Integer.parseInt(String.valueOf(Math.round(result_number)));
		        	   txtResult.setText(tmpI + "");
		        }else {
		        	   txtResult.setText(result_number + "");
		           }
		        
		        //txtResult.setText(result_number + "");
		        oper="=";
		        
		    }
		    
		});
		btnClear.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	result_number=0;
		    	txtResult.setText("");
		    	
		    }
		    
		});
		
	
	}
	
	

}
	

