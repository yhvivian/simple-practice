package com.zhuanzhuan.algorithm;

import entity.Node;

public class LinkReverse {

	public static void main(String[] args){
		
	  Node node1 = new Node(); 
	  Node node2 = new Node(); 
	  Node node3 = new Node(); 
	  Node node4 = new Node(); 
	  /*node1.setData(1);
	  node1.setNextNode(null);*/
	  
	  /*node2.setData(2);
	  node2.setNextNode(node3);
	  
	  node3.setData(3);
	  node3.setNextNode(node4);
	  
	  node4.setData(4);
	  node4.setNextNode(null);*/
	  
	 Node reversHead = reverseLink(node1);
	 StringBuilder sb = new StringBuilder();
	 Node tmpNode = reversHead;
	 while(tmpNode != null){
		 sb.append(tmpNode.getData()).append(" ");
		 tmpNode = tmpNode.getNextNode();
	 }
	 System.out.println(sb.toString());
	 System.out.println("finished!");
	}
	
	
	public static Node reverseLink(Node headNode){
		
		if(headNode == null)
			throw new IllegalArgumentException("链表为空！");
		
		Node preNode = null;
		Node currentNode = headNode;
		Node nextNode = headNode.getNextNode();
		
		while(currentNode != null){					
			currentNode.setNextNode(preNode);
			preNode =  currentNode;
			if(null == nextNode)
				return currentNode;
			currentNode = nextNode;
			nextNode = currentNode.getNextNode();
		}		
		return currentNode;
	}
}
