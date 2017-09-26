package com.bjss.traffic.api;

import java.io.IOException;

import org.junit.Assert;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;

public class MessageQueues {
	
	public MessageQueues(){
		
	}
	//public static void main(String[] args) throws MQException{
	public void checkQueue(String username, String time) throws MQException{
		int openOptions = CMQC.MQOO_BROWSE | CMQC.MQOO_INQUIRE | CMQC.MQOO_FAIL_IF_QUIESCING | CMQC.MQOO_INPUT_SHARED;
		int counter = 1;
		int numoffoundrecs = 0;
		String queue = "BIG.ER.TRAFFIC.TM_T";
		Boolean found = false;
		
		MQEnvironment.hostname = "ad-oa-mqs0.rmg-oa.local";
		MQEnvironment.port = 1416;
		MQEnvironment.channel = "QMAP02Q.READER.TM";
 
		MQQueueManager qMgr = new MQQueueManager("QMAP02Q");
		MQQueue destQueue = qMgr.accessQueue(queue, openOptions);
		System.out.println(queue+" size:" + destQueue.getCurrentDepth());
		
		MQMessage theMessage    = new MQMessage();
		MQGetMessageOptions gmo = new MQGetMessageOptions();
		gmo.options= CMQC.MQGMO_CONVERT | CMQC.MQGMO_WAIT | CMQC.MQGMO_BROWSE_NEXT;
		gmo.matchOptions=CMQC.MQMO_NONE;
		gmo.waitInterval=5000;

		while(destQueue.getCurrentDepth() >= counter){
		    try{
		        //read the message          
		    	destQueue.get(theMessage,gmo);  
		        //print the text            
		        String msgText = theMessage.readStringOfByteLength(theMessage.getMessageLength());
		        //System.out.println("msg text: "+msgText);
		        if (msgText.contains(username) && 
		        		msgText.contains(time)){
		        	numoffoundrecs++;
		        	System.out.println("msg text: "+msgText);
		        }
		        //Assert.assertTrue(msgText.contains("testing"));
		        //move cursor to the next message               
		        //gmo.options = CMQC.MQGMO_CONVERT | CMQC.MQGMO_WAIT | CMQC.MQGMO_BROWSE_NEXT;
		        counter++;

		    }catch(MQException e){

		        if(e.reasonCode == e.MQRC_NO_MSG_AVAILABLE) {
		            System.out.println("no more message available or retrived");
		        }

		        //thereAreMessages=false;
		    } catch (IOException e) {
		        System.out.println("ERROR: "+e.getMessage());
		    }
		}
		System.out.println("Records found = "+numoffoundrecs);
		Assert.assertTrue(numoffoundrecs > 0);
		destQueue.close();
		qMgr.disconnect();
	}
}
