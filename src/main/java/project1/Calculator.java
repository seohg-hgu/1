package project1;

import java.util.Stack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import java.util.ArrayList;

public class Calculator {
	static Text    txtResult;                              // 이미지 버튼
	static Button  btnNumber[]= new Button[10];  // 0~9 숫자
	static Button  btnSum, btnMinus, btnMulti, btnDiv, btnSqrt, btnGT,btnSign;     // 차례대로 +, -, x, /
	static Button  btnEqual, btnClear, btnDot,btnHis,btnMod,btnBack;             // 차례대로 =, clear, .
	static Button  btnMC, btnMR, btnMS,btnMP,btnMN,btnOF;
	static String input_number="";                           // 입력 값
	static double result_number;                          // 결과 값
    static String  oper;                        // 사칙연산
    static int tmpI;
    static int idx;
    static double memory;
	static Composite comp ;
	static double M;
	
	
	static Stack<String> stack = new Stack<String>() ;
	static ArrayList<String> list = new ArrayList<String>();
	static Stack<String> post = new Stack<String>();
	static Stack<String> intS = new Stack<String>();
	static ArrayList<String> his = new ArrayList<String>();
	static ArrayList<Double> result= new ArrayList<Double>();
	

	
	
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
		comp.setLayout(new GridLayout(5, false));
	

		 GridData gridData = new GridData(GridData.FILL_BOTH);
	     gridData.horizontalSpan = 5;
	     
	     txtResult = new Text(comp, SWT.BORDER|SWT.RIGHT);
	     txtResult.setLayoutData(gridData);
	      
	        
        GridData gData = new GridData(GridData.FILL_BOTH);
        
        GridData gDataH = new GridData(GridData.FILL_BOTH);
        gDataH.horizontalSpan = 1;
        
        GridData gDataV= new GridData(GridData.FILL_BOTH);
        gDataV.verticalSpan = 2;
        
		
        btnOF			= new Button(comp, SWT.PUSH);
        btnOF        	.setLayoutData(gData);
        btnOF        	.setText("On/Off");
        
        btnHis 			= new Button(comp, SWT.PUSH);
        btnHis        	.setLayoutData(gData);
        btnHis        	.setText("");
                
        btnGT			= new Button(comp, SWT.PUSH);
        btnGT        	.setLayoutData(gData);
        btnGT        	.setText("GT");
        
        btnClear        = new Button(comp, SWT.PUSH);
        btnClear        .setLayoutData(gData);
        btnClear        .setText("Clear");
        
        btnBack			= new Button(comp, SWT.PUSH);
        btnBack        	.setLayoutData(gData);
        btnBack        	.setText("←");
        
        btnMC 			= new Button(comp, SWT.PUSH);
        btnMC        	.setLayoutData(gData);
        btnMC        	.setText("MC");
        
        btnSqrt 		 = new Button(comp, SWT.PUSH);
        btnSqrt          .setLayoutData(gData);
        btnSqrt          .setText("√");
        
        btnMod 			= new Button(comp, SWT.PUSH);
        btnMod        	.setLayoutData(gData);
        btnMod        	.setText("tax+");
        
        
        btnDiv          = new Button(comp, SWT.PUSH);
        btnDiv          .setLayoutData(gData);
        btnDiv          .setText("/");
        
        btnMulti        = new Button(comp, SWT.PUSH);
        btnMulti        .setLayoutData(gData);
        btnMulti        .setText("x");
        
        btnMR 			= new Button(comp, SWT.PUSH);
        btnMR        	.setLayoutData(gData);
        btnMR        	.setText("MR");
        
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
        
        btnMS 			= new Button(comp, SWT.PUSH);
        btnMS        	.setLayoutData(gData);
        btnMS        	.setText("MS");
        
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
        
        btnMP 			= new Button(comp, SWT.PUSH);
        btnMP        	.setLayoutData(gData);
        btnMP        	.setText("M+");
        
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
        
        btnMN 			= new Button(comp, SWT.PUSH);
        btnMN        	.setLayoutData(gData);
        btnMN        	.setText("M-");
        
        btnSign			= new Button(comp, SWT.PUSH);
        btnSign		    .setLayoutData(gData);
        btnSign	  		.setText("+/-");
        
        btnNumber[0]    = new Button(comp, SWT.PUSH);
        btnNumber[0]    .setLayoutData(gData);
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
		           //Double tmp = Double.parseDouble(input_number);
		           txtResult.setText(input_number);
		           //list.add(input_number);
		           /*if(tmp%1==0) {
		        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
		        	   txtResult.setText(tmpI + "");
		           }else {
		        	   txtResult.setText(tmp + "");
		           }*/
		        }
		                
		     });
		    
		}
		
		
		btnOF.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		    }
		});
		btnMC.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	M=0;
		    }
		});
		btnMR.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	txtResult.setText(Double.toString(M));
		    }
		});
		btnMS.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	if(input_number=="") {
		    		M=memory;
		    	}else {
		    		M=Double.parseDouble(input_number);
		    	}
		    }
		});
		btnMP.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		    	double n;
		        // TODO Auto-generated method stub
		    	if(input_number=="") {
		    		n=M+memory;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    		
		    	}else {
		    		n=Double.parseDouble(input_number)+M;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    	}
		    }
		});
		btnMN.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	double n;
		    	if(input_number=="") {
		    		n=memory-M;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    		
		    	}else {
		    		n=Double.parseDouble(input_number)-M;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    	}
		    }
		});
		btnDot.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	input_number+=".";
		    }
		});
		
		btnSign.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	
		    	if(input_number.contains("-")) {
		    		input_number=input_number.substring(1, input_number.length());
		    	}else {
		    		input_number="-"+input_number;
		    	}
		    }
		});
		
		btnBack.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	if(input_number=="") {
		    		input_number=Double.toString(memory);
		    	}
		    	if(input_number.length()!=0) {
		    		input_number=input_number.substring(0, input_number.length()-1);
		    	}else {
		    		input_number="";
		    	}
		    	
		    	txtResult.setText(input_number);
		    }
		});
		
		
		btnSum.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	oper = "+";
		    	if(input_number=="") {
		    		input_number=Double.toString(memory);
		    	}
		    	if(input_number.contains("√")) {
		    		input_number=input_number.substring(1, input_number.length());
		    		double n=Math.sqrt(Double.parseDouble(input_number));
		    		input_number=Double.toString(n);
		    	}
		        result_number += Double.parseDouble(input_number);
		        //Double tmp = Double.parseDouble(input_number);
		        list.add(input_number);
		        list.add(oper);
		        /*if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }*/
		        
		        //oper = "+";
		        input_number = "";
		        
		    }
		    
		});
		
		
		btnMinus.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	oper = "-";
		    	if(input_number=="") {
		    		input_number=Double.toString(memory);
		    	}
		    	if(input_number.contains("√")) {
		    		input_number=input_number.substring(1, input_number.length());
		    		double n=Math.sqrt(Double.parseDouble(input_number));
		    		input_number=Double.toString(n);
		    	}
		        //result_number += Integer.parseInt(input_number);
		        
		        Double tmp = Double.parseDouble(input_number);
		        list.add(input_number);
		        list.add(oper);
		        /*if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }*/
		        //oper = "-";
		        input_number = "0";
		        
		    }
		    
		});
		btnMulti.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	oper = "*";
		        //result_number += Integer.parseInt(input_number);
		    	if(input_number=="") {
		    		input_number=Double.toString(memory);
		    	}
		    	if(input_number.contains("√")) {
		    		input_number=input_number.substring(1, input_number.length());
		    		double n=Math.sqrt(Double.parseDouble(input_number));
		    		input_number=Double.toString(n);
		    	}
		        Double tmp = Double.parseDouble(input_number);
		        list.add(input_number);
		        list.add(oper);
		        /*if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }*/
		        
		        //oper = "*";
		        input_number = "";
		        
		    }
		    
		});
		btnDiv.addListener(SWT.Selection, new Listener() {

		    @Override
		    public void handleEvent(Event event) {
		        // TODO Auto-generated method stub
		    	oper = "/";
		        //result_number += Integer.parseInt(input_number);
		    	if(input_number=="") {
		    		input_number=Double.toString(memory);
		    	}
		    	if(input_number.contains("√")) {
		    		input_number=input_number.substring(1, input_number.length());
		    		double n=Math.sqrt(Double.parseDouble(input_number));
		    		input_number=Double.toString(n);
		    	}
		        Double tmp = Double.parseDouble(input_number);
		        list.add(input_number);
		        list.add(oper);
		        /*if(oper!="=") {
		        	if(tmp%1==0) {
			        	   tmpI=Integer.parseInt(String.valueOf(Math.round(tmp)));
			        	   txtResult.setText(tmpI + "");
			           }else {
			        	   txtResult.setText(tmp + "");
			           }
		        }*/
		        
		        //oper = "/";
		        input_number = "";
		        
		    }
		    
		});
		btnEqual.addListener(SWT.Selection, new Listener() {
			String tmp;
		    @Override
		    public void handleEvent(Event event) {
		    	
		    	//convert to postfix
		    	if(input_number.contains("√")) {
		    		input_number=input_number.substring(1, input_number.length());
		    		double n=Math.sqrt(Double.parseDouble(input_number));
		    		input_number=Double.toString(n);
		    	}
		    	list.add(input_number);
		    	for(int i=0;i<list.size();i++) {
		    		//System.out.println(list.get(i));
		    	}
		    	
		    	for (int i = 0; i < list.size(); i++) {
		    		if (is_operand(list.get(i))) {
		    			post.push(list.get(i));
		    		}
		    		else {
		    			if (list.get(i) == "(") {
		    				stack.push(list.get(i));
		    			}
		    			else if (list.get(i) == ")") {
		    				while (true) {
		    					tmp = stack.pop();
		    					if (tmp == "(") {
		    						break;
		    					}
		    					post.push(tmp);
		    				}
		    				stack.pop();
		    			}
		    			else {
		    				while (!stack.empty() && precedence(stack.lastElement(), list.get(i)) >= 0) {
		    					post.push(stack.pop());
		    				}
		    				stack.push(list.get(i));
		    			}
		    		}
		    		
		    	}
		    	
		    	while(!stack.empty()) {
		    		post.push(stack.pop());
		    	}
		    	//System.out.println();
		    	
		    	/*for(int i=0;i<post.size();i++) {
		    		System.out.println(post.get(i));
		    	}*/
		    	//calculate postfix
		    	
		    	/*for(int i=post.size()-1;i>0;i--) {
		    		if(is_operand(post.get(i))) {
		    			intS.push(post.get(i));
		    			System.out.println(intS.peek());
		    		}
		    	}*/
		    	
		    	
		    	for(int i=0;i<post.size();i++) {
		    		double oper1, oper2;
		    		String result;
		    		String op=post.get(i);
		    
		    		if(is_operand(post.get(i))) {
		    			intS.push(post.get(i));
		    		}else {
		    			if(op.equals("+")) {
			    			oper2=Double.parseDouble(intS.pop());
			    			oper1=Double.parseDouble(intS.pop());
			    			result=Double.toString(oper1+oper2);
			    			intS.push(result);
			    		}
			    		else if(op.equals("*")) {
			    			oper2=Double.parseDouble(intS.pop());
			    			oper1=Double.parseDouble(intS.pop());
			    			result=Double.toString(oper1*oper2);
			    			intS.push(result);
			    		}
			    		else if(op.equals("-")) {
			    			oper2=Double.parseDouble(intS.pop());
			    			oper1=Double.parseDouble(intS.pop());
			    			result=Double.toString(oper1-oper2);
			    			intS.push(result);
			    		}
			    		else if(op.equals("/")) {
			    			oper2=Double.parseDouble(intS.pop());
			    			oper1=Double.parseDouble(intS.pop());
			    			result=Double.toString(oper1/oper2);
			    			intS.push(result);
			    			
			    		}
		    		}
		    		
		    		/*System.out.println();
		    		for(int j=0;j<intS.size();j++) {
		    			System.out.println(intS.get(j));
		    		}*/
		    	}
		    	result_number=Double.parseDouble(intS.pop());
		    	/*
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
				*/
		        
		        if(result_number%1==0) {
		        	   tmpI=Integer.parseInt(String.valueOf(Math.round(result_number)));
		        	   txtResult.setText(tmpI + "");
		        }else {
		        	   txtResult.setText(result_number + "");
		           }
		        
		        String l = "";
		        for(String str: list) {
		        	l+=str;
		        }
		        l+=" = ";
		        l+=Double.toString(result_number);
		        his.add(l);
		        //txtResult.setText(result_number + "");
		        oper="=";
		        
		        result.add(result_number);
		        
		        memory=result_number;
		        
		        result_number=0;
		    	input_number="";
		    	stack.clear();
		    	list.clear();
		    	post.clear();
		        
		    }
		    
		});
		btnClear.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	result_number=0;
		    	input_number="";
		    	txtResult.setText("");
		    	stack.clear();
		    	list.clear();
		    	post.clear();
		    	result.clear();
		    	his.clear();
		    	idx=his.size()-1;
		    	memory=0;
		    	
		    }
		    
		});

		btnHis.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	if(his.size()==0) {
		    		System.out.println("");
		    		
		    	}else {
		    		if(idx<0) {
			    		idx=his.size()-1;
			    	}
		    		txtResult.setText(his.get(idx));
			    	idx--;
		    	}
		    	if(his.size()>10) {
		    		his.remove(10);
		    	}
		    	
	    		
		    }
		    
		});
		
		btnSqrt.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	input_number+="√";
		    	txtResult.setText(input_number);
		    }
		});
		
		btnGT.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	double total=0;
		    	String totalS="";
		    	
		    	for(int i=0;i<result.size();i++) {
		    		total+=result.get(i);
		    	}
		    	
		    	for(int i=0;i<result.size();i++) {
		    		if(i==result.size()-1) {
		    			totalS=totalS+Double.toString(result.get(i))+" = "+Double.toString(total);
		    		}else {
		    			totalS=totalS+Double.toString(result.get(i))+" + ";
		    		}
		    	    		
		    	}
		    	txtResult.setText(totalS);
		    	
		    }
		    	
	    		
		    });
		
		btnMod.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	double n;
		        // TODO Auto-generated method stub
		    	if(input_number=="") {
		    		n=memory+memory*0.1;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    		
		    	}else {
		    		n=Double.parseDouble(input_number)+Double.parseDouble(input_number)*0.1;
		    		input_number=Double.toString(n);
		    		txtResult.setText(Double.toString(n));
		    	}
		    }
		   });
		
	}
	static boolean is_operand(String ch) {
		if (ch.equals("(") || ch.equals(")") || ch.equals("+") ||ch.equals("-") ||
				ch.equals("/") || ch.equals("*") || ch.equals("%") || ch.equals("$")) {
			return false;
		}
		else {
			return true;
		}
	}
	static int get_precedence(String op) {
		if (op.equals("$") || op.equals("(")) {
			return (-1);
		}
		if (op.equals("+") || op.equals("-")) {
			return (0);
		}
		if (op.equals("*") || op.equals("/") || op.equals("%")) {
			return (1);
		}
		return -3;
	}

	static int precedence(String op1, String op2) {
		int op1prec = get_precedence(op1);
		int op2prec = get_precedence(op2);
		if (op1prec > op2prec) {
			return 1;
		}
		else if (op1prec < op2prec) {
			return -1;
		}
		else {
			return 0;
		}

	}
	

}