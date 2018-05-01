/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;
import java.util.*;
/**
 *
 * @author 15012934
 */
public class OrderedLinkedList<T> implements PriorityQueue<T> {
     LinkList theLinkedList = new LinkList();
        public int priority;
        
        public T alarmName;
       

        public OrderedLinkedList next;
        
        public OrderedLinkedList(T alarmName, int priority){
            this.priority = priority;
            this.alarmName = alarmName;
        }

    OrderedLinkedList() {
      
         
         
    }
    

        
        public String toString(){ //takes the object "item" and puts it to string
            String result = theLinkedList.theString(); //sets theLinkedList through theString method to get the string for it
           
          return result;  //returns the string
        }

    public void add(T alarmName, int priority)  { //creates a new link using the item and priority variables
        
   
        
        theLinkedList.insertFirstLink(alarmName,priority); //calls the "insertFirstLink" method 
            
       
        
    }

    
    public T head()   { //returns the highest priority item, in the case of the ordered list it should always be the first item.
     
       
    
      return  theLinkedList.find(alarmName,priority);
        
        
    }


    
    public void remove() { //removes the item with the highest priority
        if (!theLinkedList.isEmpty()){
        theLinkedList.removeFirst(); //runs the removeLink method
        
        }
    }

    
    public boolean isEmpty() { //checks if the list is empty.
        return theLinkedList.isEmpty(); //basically just checks if the firstLink in the list is null or not.
    }

   
    public T nextLink(T alarmNames,int prioritys) {
            return  theLinkedList.nextLink(prioritys);
    }

    
        
        
       
        
        
class LinkList{
    public OrderedLinkedList firstLink;
     public Object PriorityItem = null; //creates and object for the highest prio item, used in the remove method
    LinkList(){ //sets the list to be empty
        firstLink = null;
        
    }
    
    
    /*Checks if the list is empty*/
    public boolean isEmpty(){ //checks if the list is empty by checking the first link
        return(firstLink == null);
    }
    
    
    /*returns nextLink*/
    public T nextLink(int priority){
         OrderedLinkedList theLink = firstLink; //creates a link 
        OrderedLinkedList highLink = firstLink; //creates a link that is the link behind the other 
        PriorityItem = new Object();
        
        
        
        
        
        if(!isEmpty()){
            while(theLink !=null){ //while loop to look for the highest priority link
                if(theLink.priority == priority){ //if the priority of theLink is the same as the highetst priority in 
                                                    //the queue it will set the "highLink" to be the link"
                  
                     highLink = theLink;
                } 
                  
                    theLink = theLink.next;//sets theLink to the next one so it can run through the 
                
            }
        }else {
            System.out.println("Empty List"); //this happens if empty
       
        
    }return ((PriorityItem<T>) PriorityItem).getItem();
    }
    
    /*Inserts first Link*/
    public void insertFirstLink(T alarmName, int priority){
         OrderedLinkedList pointerLink = firstLink; //creates a new link that is used to scroll through the list
         OrderedLinkedList newLink = new OrderedLinkedList(alarmName, priority); //creates a new link that is set to be the newLink
        OrderedLinkedList prevLink = firstLink; //creates a new link that is set to be a link behind the current  link

        
        while(pointerLink != null){//while loop that looks for the highest priority link and removes it
            
                
                if(pointerLink.priority > newLink.priority){ //when the priority is the highest priority in the list
                    
      
                 
                 if(pointerLink == firstLink){
                        //adds link in the first position
                     
                     newLink.next = firstLink;
                     firstLink = newLink;
                 }else{
                     //adds link into anywhere that isn't the first link
                     prevLink.next = newLink;
                    newLink.next = pointerLink;

                 }
                    
                    break; // finish the loop
                    
                }else if (pointerLink.next == null){
                    //adds link to the end of the list
                    pointerLink.next = newLink;

             
                    break;
                    
                    
                }else{prevLink = pointerLink; // scrolls to the next link
                    pointerLink = pointerLink.next;
                }
                
               
                
        }
                if(firstLink==null){ //if the list is empty it creates a firstLink
                    System.out.println("firstlink added");
                
                    firstLink = newLink;
                }

        
    } 
        
   /* Removes the first Link from the list*/
    public void removeFirst(){
        
                if(!isEmpty()){
                    System.out.println("link removed");
        firstLink = firstLink.next; //sets the second link to be the first link, removing the first link.
    }else{
                    System.out.println("Empty List");
                }
                
               
    }
    
    
    /*Returns the string value for the list*/
     public String theString(){ //displays the contents of the linked list
        OrderedLinkedList theLink = firstLink;
        String result = "[";
        Object alarmName;
     
        String priority;
        while(theLink != null){         //while loop that runs through the list outputting each item
            if(theLink != firstLink){
              result = result + ", ";  
            }
            result = result + "(";
            priority = Integer.toString(theLink.priority); //sets priority value
            alarmName =   (Object)theLink.alarmName; //sets the item value
            
            
            result = result +alarmName + ", " + priority; //adds the values to the string with a comma in between them
            
            theLink = theLink.next;
            result = result + ")";
        }
        result = result +"]"; //closes the string with a bracket
        return result;
    }
    
     /*Method used during testing to help display the list*/
    public void display(){ //DISPLAY METHOD ENTIRELY USED FOR TESTING
        OrderedLinkedList theLink = firstLink;
        while(theLink != null){
            System.out.println("this Link: " + theLink +" "+theLink.priority);
            System.out.println("next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println("");
        }
    }
    
    
    /*Finds the highest priority item in the list, in this case it's always the first item*/
    public T find(T alarmName, int priority){
        
        PriorityItem = new Object();
 
        
        
        
       
       alarmName = (T) firstLink.alarmName;
        priority = firstLink.priority;
        
       PriorityItem =  new PriorityItem<>(alarmName, priority); //the PriorityItem is created from the firstLink
        
        return ((PriorityItem<T>) PriorityItem).getItem(); //returns the item from priorityItem
    }
    
    
    
    
    
  }
}