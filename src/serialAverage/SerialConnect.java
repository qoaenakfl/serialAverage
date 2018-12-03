package serialAverage;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;

public class SerialConnect {

	private SerialReader reader;
	private StringBuffer str;
	
	void connect ( String portName ) throws Exception
    {
		setSerial();
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            //Ŭ���� �̸��� �ĺ��ڷ� ����Ͽ� ��Ʈ ����
            CommPort commPort = portIdentifier.open(this.getClass().getName(),3000);
            
            if ( commPort instanceof SerialPort )
            {
                //��Ʈ ����(��żӵ� ����)
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                
                //Input,OutputStream ���� ���� �� ����
                InputStream in = serialPort.getInputStream();
                
                 //�б�, ���� ������ �۵�
                reader = new SerialReader(in);
                (new Thread(reader)).start();
            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }
	
	public synchronized String getSerial(){
		String s = str.toString();
		return s;
	}
	
	public  synchronized void setSerial(){
		str = new StringBuffer();
	}
    
    /** */
    //������ ����
    public class SerialReader implements Runnable 
    {
        InputStream in;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void run ()
        {
            while(true){
            	byte[] buffer = new byte[1024];
                int len = -1;
                
                try{
                	synchronized (str) {
                		while ( ( len = this.in.read(buffer)) > 0 ){
                    		str.append(new String(buffer,0,len));
                        }
                		if(str.toString() != null)
                			System.out.println("Listen Data : "+str.toString());
					}
                }
                catch ( IOException e ){
                    e.printStackTrace();
                }
            }
        }
    }
}
